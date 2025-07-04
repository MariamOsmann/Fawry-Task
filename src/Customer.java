public class Customer {
    String name;
    double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
     // check if your balance is enough
    public void pay(double amount) {
        if (balance >= amount)
            balance -= amount;
        else
            throw new IllegalArgumentException("insufficient balance");


    }
}