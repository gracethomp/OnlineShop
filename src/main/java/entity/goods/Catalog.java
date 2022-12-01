package entity.goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalog {
    private String title;
    private List<Product> products;
    public Catalog(){}
    public Catalog(String title) {
        this.title = title;
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getTitle() {
        return title;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(title, catalog.title) && Objects.equals(products, catalog.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, products);
    }

    @Override
    public String toString() {
        return "Catalog title is" + title + '\n' +
                "and it has the next products " + products;
    }
}
