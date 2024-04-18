package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Customer;

public interface FindOneCustomerUseCase {
    Customer execute(Long id);
}
