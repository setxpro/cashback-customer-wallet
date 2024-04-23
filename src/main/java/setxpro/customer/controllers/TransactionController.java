package setxpro.customer.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import setxpro.customer.core.entities.Transaction;
import setxpro.customer.core.usecases.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    private final CreateTransactionUseCase createTransactionUseCase;
    private final FindAllTransactionsUseCase findAllTransactionsUseCase;
    private final FindOneTransactionUseCase findOneTransactionUseCase;
    private final FindByTransactionSentUseCase findByTransactionSentUseCase;
    private final FindByTransactionReceivedUseCase findbyTransactionReceivedUseCase;

    public TransactionController(CreateTransactionUseCase createTransactionUseCase, FindAllTransactionsUseCase findAllTransactionsUseCase, FindOneTransactionUseCase findOneTransactionUseCase, FindByTransactionSentUseCase findByTransactionSentUseCase, FindByTransactionReceivedUseCase findbyTransactionReceivedUseCase) {
        this.createTransactionUseCase = createTransactionUseCase;
        this.findAllTransactionsUseCase = findAllTransactionsUseCase;
        this.findOneTransactionUseCase = findOneTransactionUseCase;
        this.findByTransactionSentUseCase = findByTransactionSentUseCase;
        this.findbyTransactionReceivedUseCase = findbyTransactionReceivedUseCase;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid Transaction transaction) {
        try {
            return new ResponseEntity<>(createTransactionUseCase.execute(transaction), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<?> findAll(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(findAllTransactionsUseCase.execute(id), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(findOneTransactionUseCase.execute(id), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/payer/{payerId}")
    public ResponseEntity<?> findOneBySending(@PathVariable(value = "payerId") Long payer) {
        try {
            return new ResponseEntity<>(findByTransactionSentUseCase.execute(payer), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/payee/{payeeId}")
    public ResponseEntity<?> findOneByReceived(@PathVariable(value = "payeeId") Long payee) {
        try {
            return new ResponseEntity<>(findbyTransactionReceivedUseCase.execute(payee), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
