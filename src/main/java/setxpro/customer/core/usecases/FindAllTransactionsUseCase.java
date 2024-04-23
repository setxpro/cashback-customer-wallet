package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Transaction;

import java.util.List;

public interface FindAllTransactionsUseCase {
    List<Transaction> execute(Long id) throws Exception;
}
