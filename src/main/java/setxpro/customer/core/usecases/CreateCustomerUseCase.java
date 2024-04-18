package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Customer;

public interface CreateCustomerUseCase {
    Customer execute(Customer customer);
}
