package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Transaction;
import setxpro.customer.core.gateways.TransactionGateway;

import java.util.List;

public class FindByTransactionReceivedUseCaseImpl implements FindByTransactionReceivedUseCase {
    private final TransactionGateway transactionGateway;

    public FindByTransactionReceivedUseCaseImpl(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    @Override
    public List<Transaction> execute(Long payee) throws Exception {
        return transactionGateway.findTransactionsReceived(payee);
    }
}
