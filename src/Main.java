import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProductsDB productsDB = new ProductsDB();
        Cart cart = new Cart();
        Customer customer = new Customer("Mariam", 500);

        Scanner in = new Scanner(System.in);

        System.out.println("Available Products:");
        for (Product p : productsDB.products) {
            System.out.println(p.name + " | Price: " + p.price + " | Quantity: " + p.quantity);
        }

        while (true) {
            System.out.print("Enter the product name you need , or done to checkout :  ");
            String productName = in.nextLine().trim().toLowerCase();

            if (productName.equals("done")) break;

            Product choice = productsDB.FindProduct(productName);

            if (choice == null) {
                System.out.println(" Sorry product not found");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity;
            try {
                quantity = Integer.parseInt(in.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid , Try again");
                continue;
            }

            cart.add(choice, quantity);
        }

        checkout(customer, cart);

    }

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty !!");
            return;
        }

        double subtotal = cart.calculateSubtotal();

        double shipping = cart.calculateShipping();

        double total = subtotal + shipping;

        try {
            customer.pay(total);
        } catch (IllegalArgumentException e) {
            System.out.println(" Payment failed : " + e.getMessage());
            return;
        }


        System.out.println(" || Shipment notice || ");
        for (CartItem item : cart.getItems()) {
            if (item.product.isShippable) {
                System.out.println(item.quantity + "x " + item.getName()+" "+ (int)(item.getWeight() / item.quantity * 1000) + "gram");
            }
        }

        double totalWeight = cart.totalWeight();
        if (totalWeight > 0) {
            System.out.println("Total  weight: " + totalWeight + "kg");
        }

        System.out.println(" || Checkout receipt || ");
        for (CartItem item : cart.getItems()) {
            if (item.product.isShippable) {
                System.out.println(item.quantity + "x " + item.getName()+ " " + item.getTotalPrice());
            }
        }

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shipping);
        System.out.println("Amount: " + total);
        System.out.println("Payment successful ,  your new balance: " + customer.balance);
    }
}