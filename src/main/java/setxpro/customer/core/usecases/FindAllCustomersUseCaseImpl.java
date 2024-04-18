package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Customer;
import setxpro.customer.core.gateways.CustomerGateway;

import java.util.List;

public class FindAllCustomersUseCaseImpl implements FindAllCustomersUseCase {
    private final CustomerGateway customerGateway;

    public FindAllCustomersUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public List<Customer> execute() {
        return customerGateway.findAll();
    }
}
