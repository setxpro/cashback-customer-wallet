package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Transaction;

public interface FindOneTransactionUseCase {
    Transaction execute(Long id) throws Exception;
}
