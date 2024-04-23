package setxpro.customer.services;

import org.springframework.stereotype.Service;
import setxpro.customer.core.entities.Customer;
import setxpro.customer.infra.database.models.CustomerEntity;
import setxpro.customer.infra.database.repositories.CustomerRepository;

@Service
public class LoadBalance {

    private final CustomerRepository customerRepository;

    public LoadBalance(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveBalance(CustomerEntity customer) {
        customerRepository.save(customer);
    }

}
