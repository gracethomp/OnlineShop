package entity.lists;

import entity.Product;
import entity.lists.ListForUsers;

import java.util.List;

public class SeenList extends ListForUsers {
    public List<Product> order() {
        return getProducts();
    }
}
