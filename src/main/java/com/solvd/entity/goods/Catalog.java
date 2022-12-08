package com.solvd.entity.goods;

import com.solvd.exceptions.OnlineShopEmptyTitleException;
import com.solvd.exceptions.OnlineShopNullPointerException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalog {
    private String title;
    private List<Product> products;

    private static final Logger LOGGER = Logger.getLogger(Catalog.class);

    public Catalog(){}
    public Catalog(String title) {
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        this.title = title;
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        LOGGER.trace("products from catalog were gotten");
        return products;
    }

    public String getTitle() {
        LOGGER.trace("title from catalog was gotten");
        return title;
    }

    public void setProducts(List<Product> products) {
        LOGGER.trace("products were set");
        this.products = products;
    }

    public void setTitle(String title) {
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        LOGGER.trace("title was set");
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
