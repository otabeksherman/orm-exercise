package Client;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private int money_balance;

    public User() {
    }

    public User(int id, String name, String email, String password, int money_balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.money_balance = money_balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney_balance(int money_balance) {
        this.money_balance = money_balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getMoney_balance() {
        return money_balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", money_balance=" + money_balance +
                '}';
    }
}
