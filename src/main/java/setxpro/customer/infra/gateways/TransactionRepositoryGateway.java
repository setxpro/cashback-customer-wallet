package setxpro.customer.infra.gateways;

import org.springframework.stereotype.Component;
import setxpro.customer.core.entities.Customer;
import setxpro.customer.core.entities.Transaction;
import setxpro.customer.core.gateways.TransactionGateway;
import setxpro.customer.core.usecases.FindOneCustomerUseCase;
import setxpro.customer.core.usecases.FindOneTransactionUseCase;
import setxpro.customer.infra.database.models.CustomerEntity;
import setxpro.customer.infra.database.repositories.CustomerRepository;
import setxpro.customer.infra.database.repositories.TransactionRepository;
import setxpro.customer.infra.mappers.CustomerMapper;
import setxpro.customer.infra.mappers.TransactionMapper;
import setxpro.customer.services.AuthorizationService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TransactionRepositoryGateway implements TransactionGateway {

    // Usecase

    private final FindOneCustomerUseCase findOneCustomerUseCase;

    // Repository
    private final TransactionRepository transactionRepository;

    // Mappers
    private final TransactionMapper transactionMapper;
    private final CustomerMapper customerMapper;

    // Validation
    private final AuthorizationService authorizationService;

    // Customer
    private final CustomerRepository customerRepository;
    public TransactionRepositoryGateway(FindOneCustomerUseCase findOneCustomerUseCase, TransactionRepository transactionRepository, TransactionMapper transactionMapper, CustomerMapper customerMapper, AuthorizationService authorizationService, CustomerRepository customerRepository) {
        this.findOneCustomerUseCase = findOneCustomerUseCase;
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
        this.customerMapper = customerMapper;
        this.authorizationService = authorizationService;
        this.customerRepository = customerRepository;
    }

    @Override
    public Transaction create(Transaction transaction) throws Exception {

        /*
            * 1. Identify payee and payer by id
        */

        // Who pays
        Optional<CustomerEntity> payer = customerRepository.findById(transaction.getPayer());

        Customer sending = findOneCustomerUseCase.execute(transaction.getPayer());
        Customer received = findOneCustomerUseCase.execute(transaction.getPayee());

        /*
            * 2. Verify authorization (if credit in account is more than total transaction)
        */
        boolean isAuthorized = authorizationService.authorizationTransaction(sending, transaction.getAmount());

        if (!isAuthorized) {
            throw new Exception("Transação não autorizada.");
        }

        /*
            * 3. Create a new Transaction
        */

        // Set Current Date
        transaction.setCreatedAt(LocalDateTime.now());

        // DEBIT ACCOUNT (sending)
        sending.getWallet().setBalance(sending.getWallet().getBalance().subtract(transaction.getAmount()));
        received.getWallet().setBalance(received.getWallet().getBalance().add(transaction.getAmount()));

        // UPDATE BALANCE
        customerRepository.save(customerMapper.toEntity(sending));
        customerRepository.save(customerMapper.toEntity(received));

        // Save Transaction
        transactionRepository.save(transactionMapper.toEntity(transaction));

        // Send notifications about successfully transaction
        //        this.notificationService.sendNotification(sender, "Transação realizada com sucesso!");
        //        this.notificationService.sendNotification(receiver, "Transação recebida com sucesso!");
        return transaction;
    }

    @Override
    public List<Transaction> findAllById(Long id) throws Exception {
        return transactionRepository.findAllById(id).stream().map(transactionMapper::toDomainEntity).collect(Collectors.toList());
    }

    @Override
    public Transaction findOne(Long id) throws Exception {
        Optional<Transaction> transaction = transactionRepository.findById(id).map(transactionMapper::toDomainEntity);
        if (transaction.isPresent()) {
            return transaction.get();
        } else {
            throw new Exception("Transaction do not exists!");
        }
    }

    @Override
    public List<Transaction> findTransactionsSending(Long payer) throws Exception {
        return transactionRepository.findByPayer(payer).stream().map(transactionMapper::toDomainEntity).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findTransactionsReceived(Long payee) throws Exception {
        return transactionRepository.findByPayee(payee).stream().map(transactionMapper::toDomainEntity).collect(Collectors.toList());
    }
}
