package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Customer;
import setxpro.customer.core.gateways.CustomerGateway;

public class FindOneCustomerUseCaseImpl implements FindOneCustomerUseCase {
    private final CustomerGateway customerGateway;

    public FindOneCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }
    @Override
    public Customer execute(Long id) {
        return customerGateway.findOne(id);
    }
}
