public class CartItem {
    Product product;
    double quantity;

    public CartItem(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.price * quantity;
    }

    public String getName() {
        return product.name;
    }

    public double getWeight() {
   if(product.isShippable)
       return product.weight*quantity;
   else
       return 0;
    }
}