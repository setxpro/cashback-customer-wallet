package setxpro.customer.infra.gateways;

import org.springframework.stereotype.Component;
import setxpro.customer.core.dtos.CustomerDTO;
import setxpro.customer.core.entities.Customer;
import setxpro.customer.core.gateways.CustomerGateway;
import setxpro.customer.infra.database.repositories.CustomerRepository;
import setxpro.customer.infra.mappers.CustomerMapper;
import setxpro.customer.infra.utils.MethodUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerRepositoryGateway implements CustomerGateway {

    // Entity Repository
    private final CustomerRepository customerRepository;
    // Mapper
    private final CustomerMapper customerMapper;

    private final MethodUtil methodUtil;

    public CustomerRepositoryGateway(CustomerRepository customerRepository, CustomerMapper customerMapper, MethodUtil methodUtil) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.methodUtil = methodUtil;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerMapper.toDomainEntity(
                customerRepository.save(
                        customerMapper.toEntity(customer)
                )
        );
    }

    @Override
    public List<Customer> findAll() {
        // FIND ALL CUSTOMERS WITHOUT WALLET
        return customerRepository.findAll().stream().map(customerMapper::toCustomerDomainEntity).collect(Collectors.toList());
    }

    @Override
    public Customer findOne(Long id) {
        // FIND ONE CUSTOMER WITH YOUR WALLET
        Optional<Customer> customer = customerRepository.findById(id).map(customerMapper::toDomainEntity);
        if (customer.isPresent()) {
             return customer.get();
        } else {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
    }

    @Override
    public Customer updateOne(Long id, CustomerDTO updateCustomerDTO) {
        Customer currentCustomer = findOne(id);

        if (currentCustomer != null) {
            methodUtil.copyNonNullProperties(updateCustomerDTO, currentCustomer);

            // UPDATE CUSTOMER WITHOUT WALLET
            return customerMapper.toCustomerDomainEntity(
                    customerRepository.save(
                            customerMapper.toEntity(currentCustomer)
                    )
            );
        } else {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
    }

    @Override
    public void deleteOne(Long id) {
        customerRepository.deleteById(id);
    }
}
