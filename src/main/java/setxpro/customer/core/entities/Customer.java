package setxpro.customer.core.entities;

public class Customer {
    private Long id;
    private String fullname;
    private String email;
    private String avatar;
    private Wallet wallet;
    private String username;
    private String password;

    public Customer(Long id, String fullname, String email, String avatar, Wallet wallet, String username, String password) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.avatar = avatar;
        this.wallet = wallet;
        this.username = username;
        this.password = password;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
