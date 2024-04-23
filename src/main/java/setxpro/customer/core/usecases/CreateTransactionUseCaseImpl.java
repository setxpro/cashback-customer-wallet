package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Transaction;
import setxpro.customer.core.gateways.TransactionGateway;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private final TransactionGateway transactionGateway;
    public CreateTransactionUseCaseImpl(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    @Override
    public Transaction execute(Transaction transaction) throws Exception {
        return transactionGateway.create(transaction);
    }
}
