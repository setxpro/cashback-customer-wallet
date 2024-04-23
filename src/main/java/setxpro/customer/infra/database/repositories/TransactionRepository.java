package setxpro.customer.infra.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import setxpro.customer.infra.database.models.TransactionEntity;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> findByPayer(Long payer);
    List<TransactionEntity> findByPayee(Long payee);
    @Query(value = "SELECT * FROM transaction WHERE payee = :id OR payer = :id", nativeQuery = true)
    List<TransactionEntity> findAllById(@Param(value = "id") Long id);
}
