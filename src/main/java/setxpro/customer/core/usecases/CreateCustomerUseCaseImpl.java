package setxpro.customer.core.usecases;

import setxpro.customer.core.entities.Customer;
import setxpro.customer.core.entities.Wallet;
import setxpro.customer.core.gateways.CustomerGateway;

import java.math.BigDecimal;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public CreateCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public Customer execute(Customer customer) {
        BigDecimal currentBalance = new BigDecimal(0);
        Wallet wallet = new Wallet();
        wallet.setBalance(currentBalance);
        // Initial Amount
        customer.setWallet(wallet);
        return customerGateway.createCustomer(customer);
    }
}
