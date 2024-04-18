package setxpro.customer.infra.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import setxpro.customer.infra.database.models.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
