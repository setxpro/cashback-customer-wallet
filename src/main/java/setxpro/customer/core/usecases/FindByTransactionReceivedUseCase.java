package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Transaction;

import java.util.List;

public interface FindByTransactionReceivedUseCase {
    List<Transaction> execute(Long payee) throws Exception;
}
