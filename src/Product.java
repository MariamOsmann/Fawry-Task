import java.time.LocalDate;

public class Product {
    String name;
    double price;
    int quantity;

    boolean isShippable;
    double weight;

    boolean isExpirable;
    LocalDate expiryDate;

    public Product(String name, double price, int quantity,boolean isShippable, double weight,
                   boolean isExpirable, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isShippable = isShippable;
        this.weight = weight;
        this.isExpirable = isExpirable;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        if (!isExpirable) return false;

        int result = LocalDate.now().compareTo(expiryDate);
        return result > 0;

    }

    public boolean isAvailable(double CustomerRrequest) {
        return quantity >= CustomerRrequest && !isExpired();
    }

    public void ReduceQuantity(double CustomerRrequest) {
        if (isAvailable(CustomerRrequest)) {
            this.quantity -= CustomerRrequest;
        } else {
            throw new IllegalArgumentException("Unavailable or expired");
        }
    }
}