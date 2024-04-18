package setxpro.customer.infra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import setxpro.customer.core.gateways.CustomerGateway;
import setxpro.customer.core.usecases.*;

@Configuration
public class BeansConfig {
    @Bean
    public CreateCustomerUseCase customerUseCase(CustomerGateway customerGateway) {
        return new CreateCustomerUseCaseImpl(customerGateway);
    }
    @Bean
    public FindAllCustomersUseCase findAllCustomersUseCase(CustomerGateway customerGateway) {
        return new FindAllCustomersUseCaseImpl(customerGateway);
    }
    @Bean
    public FindOneCustomerUseCase findOneCustomerUseCase(CustomerGateway customerGateway) {
        return new FindOneCustomerUseCaseImpl(customerGateway);
    }
}
