package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Transaction;

import java.util.List;

public interface FindByTransactionSentUseCase {
    List<Transaction> execute(Long payer) throws Exception;
}
