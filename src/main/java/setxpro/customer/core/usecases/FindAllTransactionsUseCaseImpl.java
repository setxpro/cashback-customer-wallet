package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Transaction;
import setxpro.customer.core.gateways.TransactionGateway;

import java.util.List;

public class FindAllTransactionsUseCaseImpl implements FindAllTransactionsUseCase {

    private final TransactionGateway transactionGateway;

    public FindAllTransactionsUseCaseImpl(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    @Override
    public List<Transaction> execute(Long id) throws Exception {
        return transactionGateway.findAllById(id);
    }
}
