package entity;

import java.util.List;

public abstract class ListForUsers {
    List<Product> products;

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
}
