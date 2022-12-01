package entity.lists;

import entity.goods.Product;
import entity.lists.interfaces.Clearable;

import java.util.List;
import java.util.Objects;

public abstract class ListForUsers implements Clearable {
    private List<Product> products;

    public ListForUsers(){}
    public ListForUsers(List<Product> products) {
        this.products = products;
    }

    @Override
    public void clear() {
        products.clear();
    }

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
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
