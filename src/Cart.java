import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> items = new ArrayList<>();


    public void add(Product product, double quantity) {
        if (!product.isAvailable(quantity)) {
            System.out.println("Quantity is unavailable or it is Expired");
            return;
        }

        product.ReduceQuantity(quantity);
        items.add(new CartItem(product, quantity));
        System.out.println(" added " + product.name + " with quantity " + quantity);
    }


    public List<CartItem> getItems() {
        return items;
    }


    public boolean isEmpty() {
        return items.isEmpty();
    }


    public double calculateSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    // ShippingService
    public double calculateShipping() {
        double shippingWeight = 0;
        for (CartItem item : items) {
            if (item.product.isShippable) {
                shippingWeight += item.getWeight();
            }
        }

        return shippingWeight > 0 ? (totalWeight()*30) : 0;
    }


    public double totalWeight() {
        double weight = 0;
        for (CartItem item : items) {
            if (item.product.isShippable) {
                weight += item.getWeight();
            }
        }
        return weight;
    }
}
