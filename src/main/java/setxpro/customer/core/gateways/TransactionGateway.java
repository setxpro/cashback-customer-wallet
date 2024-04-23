package setxpro.customer.core.gateways;

import setxpro.customer.core.entities.Transaction;

import java.util.List;

public interface TransactionGateway {
    Transaction create(Transaction transaction) throws Exception;

    List<Transaction> findAllById(Long id) throws Exception;

    Transaction findOne(Long id) throws Exception;
    List<Transaction> findTransactionsSending(Long payer) throws Exception;
    List<Transaction> findTransactionsReceived(Long payee) throws Exception;
}
