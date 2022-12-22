package com.solvd.entity.goods;

import com.solvd.entity.enums.ProductTypes;
import com.solvd.entity.interfaces.Filterable;
import com.solvd.lambda.Searchable;
import com.solvd.exceptions.OnlineShopEmptyTitleException;
import com.solvd.exceptions.OnlineShopNullPointerException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Catalog implements Filterable {
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

    public List<Product> search(Searchable<Product> func) {
        List<Product> result = new ArrayList<>();
        for (Product p: products) {
            if(func.search(p))
                result.add(p);
        }
        return result;
    }

    @Override
    public List<Product> filterByTitle(String title) {
        return products.stream().filter(x -> x.getTitle().equals(title)).collect(Collectors.toList()); //1
    }

    @Override
    public List<Product> filterByPrice(double priceFrom, double priceTo) {
        return products.stream().filter(x -> x.getPrice() >= priceFrom && x.getPrice() <= priceTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> filterByType(ProductTypes type) {
        return products.stream().filter(x -> x.getType() == type).collect(Collectors.toList());
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
