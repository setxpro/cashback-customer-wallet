package setxpro.customer.infra.mappers;

import org.springframework.stereotype.Component;
import setxpro.customer.core.entities.Customer;
import setxpro.customer.core.entities.Wallet;
import setxpro.customer.infra.database.models.CustomerEntity;
import setxpro.customer.infra.database.models.WalletEntity;

@Component
public class CustomerMapper {
    public Wallet toWalletEntity(WalletEntity wallet) {
        return new Wallet(
                wallet.getId(),
                wallet.getBalance()
        );
    }

    public WalletEntity toDomainWalletEntity(Wallet wallet) {
        return new WalletEntity(
                wallet.getId(),
                wallet.getBalance()
        );
    }

    public CustomerEntity toEntity(Customer customer) {

        return new CustomerEntity(
                customer.getId(),
                customer.getFullname(),
                customer.getEmail(),
                customer.getAvatar(),
                toDomainWalletEntity(customer.getWallet()),
                customer.getUsername(),
                customer.getPassword()
        );
    }

    public Customer toDomainEntity(CustomerEntity customer) {
        return new Customer(
                customer.getId(),
                customer.getFullname(),
                customer.getEmail(),
                customer.getAvatar(),
                toWalletEntity(customer.getWallet()),
                customer.getUsername(),
                customer.getPassword()
        );
    }
    public Customer toCustomerDomainEntity(CustomerEntity customer) {
        return new Customer(
                customer.getId(),
                customer.getFullname(),
                customer.getEmail(),
                customer.getAvatar(),
                null,
                customer.getUsername(),
                customer.getPassword()
        );
    }
}
