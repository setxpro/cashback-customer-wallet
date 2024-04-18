package setxpro.customer.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import setxpro.customer.core.entities.Customer;
import setxpro.customer.core.usecases.CreateCustomerUseCase;
import setxpro.customer.core.usecases.FindAllCustomersUseCase;
import setxpro.customer.core.usecases.FindOneCustomerUseCase;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CreateCustomerUseCase create;
    private final FindAllCustomersUseCase findAll;
    private final FindOneCustomerUseCase findOne;

    public CustomerController(CreateCustomerUseCase create, FindAllCustomersUseCase findAll, FindOneCustomerUseCase findOne) {
        this.create = create;
        this.findAll = findAll;
        this.findOne = findOne;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid Customer customer) {
        return new ResponseEntity<>(create.execute(customer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(findAll.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(findOne.execute(id), HttpStatus.OK);
    }
}
