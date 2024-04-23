package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Transaction;
import setxpro.customer.core.gateways.TransactionGateway;

import java.util.List;

public class FindByTransactionSentUseCaseImpl implements FindByTransactionSentUseCase {
    private final TransactionGateway transactionGateway;

    public FindByTransactionSentUseCaseImpl(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }
    @Override
    public List<Transaction> execute(Long payer) throws Exception {
        return transactionGateway.findTransactionsSending(payer);
    }
}
