package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Transaction;

public interface CreateTransactionUseCase {
    Transaction execute(Transaction transaction) throws Exception;
}
