package entity.lists;

import entity.Product;

import java.util.List;

public class SeenList extends ListForUsers {
    public List<Product> order() {
        return getProducts();
    }

    @Override
    public String toString() {
        return "This is seen list. Products: " + super.toString();
    }
}
