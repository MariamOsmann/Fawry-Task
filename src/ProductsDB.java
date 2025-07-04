import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
// this clas looks like DataBase
public class ProductsDB {
    public List<Product> products;

    public Product FindProduct(String name) {
        for (Product product : products) {
            if (product.name.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
    public ProductsDB() {
        products = new ArrayList<>();

        products.add(new Product("Cheese", 50, 5, true, 0.4, true, LocalDate.of(2025, 7, 15)));
        products.add(new Product("Biscuits", 10, 3, true, 0.7, true, LocalDate.of(2025, 8, 10)));
        products.add(new Product("TV", 30000, 2, true, 15.0, false, null));
        products.add(new Product("ScratchCard", 80, 100, false, 0.0, false, null));

    }


}
