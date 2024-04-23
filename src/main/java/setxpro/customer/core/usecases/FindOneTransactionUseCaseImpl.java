package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Transaction;
import setxpro.customer.core.gateways.TransactionGateway;

public class FindOneTransactionUseCaseImpl implements FindOneTransactionUseCase {

    private final TransactionGateway transactionGateway;

    public FindOneTransactionUseCaseImpl(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    @Override
    public Transaction execute(Long id) throws Exception {
        return transactionGateway.findOne(id);
    }
}
