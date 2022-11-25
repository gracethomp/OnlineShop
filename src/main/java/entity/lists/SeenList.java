package entity.lists;

import entity.Product;

import java.util.Comparator;
import java.util.List;

public class SeenList extends ListForUsers {
    public List<Product> orderByPrice() {
        Comparator<Product> comparator = Comparator.comparing(Product::getPrice);
        getProducts().sort(comparator);
        return getProducts();
    }
    public List<Product> orderByTitle() {
        Comparator<Product> comparator = Comparator.comparing(Product::getTitle);
        getProducts().sort(comparator);
        return getProducts();
    }
    @Override
    public String toString() {
        return "This is seen list. Products: " + super.toString();
    }
}
