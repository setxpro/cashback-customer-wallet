package setxpro.customer.services;

import org.springframework.stereotype.Service;
import setxpro.customer.core.entities.Customer;
import setxpro.customer.infra.database.repositories.CustomerRepository;

import java.math.BigDecimal;

@Service
public class AuthorizationService {
    private final CustomerRepository customerRepository;

    public AuthorizationService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean authorizationTransaction(Customer customer, BigDecimal amount) throws Exception {

        System.out.println(customer.getWallet().getBalance());

        if (customer.getWallet().getBalance().compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Insufficient funds!");
        }
        BigDecimal balance = customerRepository.findById(customer.getId()).get().getWallet().getBalance();

        if (amount.compareTo(balance.abs()) > 0) {

            BigDecimal waiting = amount.subtract(customer.getWallet().getBalance());

            throw new Exception("Insufficient funds. Waiting $" + waiting + " to complete your transaction");
        }

        return true;
    }
}
