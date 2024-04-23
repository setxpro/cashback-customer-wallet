package setxpro.customer.infra.database.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import setxpro.customer.core.enums.TypePayment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identificador gerado automaticamente pelo banco de dados
    private Long id;
    private Long payer; // Who pays
    private Long payee; // Who receives
    private BigDecimal amount;
    private TypePayment type;
    private LocalDateTime createdAt;
}
