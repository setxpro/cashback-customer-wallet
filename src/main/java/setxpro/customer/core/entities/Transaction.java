package setxpro.customer.core.entities;

import setxpro.customer.core.enums.TypePayment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private Long payer; // Who pays
    private Long payee; // Who receives
    private BigDecimal amount;
    private TypePayment type;
    private LocalDateTime createdAt;

    public Transaction(Long id, Long payer, Long payee, BigDecimal amount,TypePayment type, LocalDateTime createdAt) {
        this.id = id;
        this.payer = payer;
        this.payee = payee;
        this.amount = amount.setScale(2);
        this.type = type;
        this.createdAt = createdAt;
    }

    public Transaction() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getPayer() {
        return payer;
    }

    public void setPayer(Long payer) {
        this.payer = payer;
    }

    public Long getPayee() {
        return payee;
    }

    public void setPayee(Long payee) {
        this.payee = payee;
    }

    public TypePayment getType() {
        return type;
    }

    public void setType(TypePayment type) {
        this.type = type;
    }
}
