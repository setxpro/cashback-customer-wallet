package setxpro.customer.core.entities;

import java.math.BigDecimal;

public class Wallet {
    private Long id;
    private BigDecimal balance;

    public Wallet(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
