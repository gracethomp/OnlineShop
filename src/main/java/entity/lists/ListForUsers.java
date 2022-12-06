package entity.lists;

import entity.goods.Product;
import entity.interfaces.Clearable;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Objects;

public abstract class ListForUsers implements Clearable {
    private List<Product> products;

    private static final Logger LOGGER = Logger.getLogger(ListForUsers.class);

    public ListForUsers(){}
    public ListForUsers(List<Product> products) {
        this.products = products;
    }

    @Override
    public void clear() {
        products.clear();
        LOGGER.debug("list is cleared" + this.getClass());
    }

    public boolean addProduct(Product product) {
        LOGGER.debug(product + "was added");
        return products.add(product);
    }

    public List<Product> getProducts() {
        LOGGER.trace("products were gotten");
        return products;
    }

    public void setProducts(List<Product> products) {
        LOGGER.trace("products were set");
        this.products = products;
    }

    @Override
    public String toString() {
        return products.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListForUsers that = (ListForUsers) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}
