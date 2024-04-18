package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Customer;

import java.util.List;

public interface FindAllCustomersUseCase {
    List<Customer> execute();
}
