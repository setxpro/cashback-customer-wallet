package setxpro.customer.core.gateways;

import setxpro.customer.core.dtos.CustomerDTO;
import setxpro.customer.core.entities.Customer;

import java.util.List;

public interface CustomerGateway {
    Customer createCustomer(Customer customer);
    List<Customer> findAll();
    Customer findOne(Long id);
    Customer updateOne(Long id, CustomerDTO updateCustomerDTO);
    void deleteOne(Long id);
}
