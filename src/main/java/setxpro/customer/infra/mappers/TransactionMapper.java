package setxpro.customer.infra.mappers;

import org.springframework.stereotype.Component;
import setxpro.customer.core.entities.Transaction;
import setxpro.customer.infra.database.models.TransactionEntity;

@Component
public class TransactionMapper {

    public TransactionEntity toEntity(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                transaction.getPayer(),
                transaction.getPayee(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getCreatedAt()
        );
    }

    public Transaction toDomainEntity(TransactionEntity transaction) {
        return new Transaction(
                transaction.getId(),
                transaction.getPayer(),
                transaction.getPayee(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getCreatedAt()
        );
    }

}
