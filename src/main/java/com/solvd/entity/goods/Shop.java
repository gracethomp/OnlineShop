package com.solvd.entity.goods;

import com.solvd.entity.enums.ProductTypes;
import com.solvd.entity.enums.Rating;
import com.solvd.entity.interfaces.Filterable;
import com.solvd.entity.reviews.Review;
import com.solvd.entity.interfaces.IComment;
import com.solvd.exceptions.OnlineShopEmptyTitleException;
import com.solvd.exceptions.OnlineShopNegativeValuesException;
import com.solvd.exceptions.OnlineShopNullPointerException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Shop implements IComment, Filterable {
    public static final String fileName = "src/main/resources/Shops.txt";

    private String title;
    private String description;
    private List<Review> reviews;
    private Rating rating;
    private int ordersCount;
    private List<Product> products;

    private static final Logger LOGGER = Logger.getLogger(Shop.class);

    public Shop() {}
    public Shop(String title, String description, Rating rating, int ordersCount){
        this.reviews = new ArrayList<>();
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        if(ordersCount < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.ordersCount = ordersCount;
        this.products = new ArrayList<>();
    }

    @Override
    public boolean addReview(Review review) {
        LOGGER.info("review is added to shop");
        return reviews.add(review);
    }

    public boolean addProduct(Product product){
        LOGGER.info("review is added to shop");
        return products.add(product);
    }

    public boolean deleteProduct(Product product) {
        return products.remove(product);
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

    public String getTitle() {
        LOGGER.trace("title was gotten");
        return title;
    }

    public String getDescription() {
        LOGGER.trace("desc was gotten");
        return description;
    }

    public List<Review> getReviews() {
        LOGGER.trace("reviews was gotten");
        return reviews;
    }

    public Rating getRating() {
        LOGGER.trace("rating was gotten");
        return rating;
    }

    public int getOrdersCount() {
        LOGGER.trace("orders count was gotten");
        return ordersCount;
    }

    public List<Product> getProducts() {
        LOGGER.trace("products was gotten");
        return products;
    }

    public void setReviews(List<Review> reviews) {
        LOGGER.trace("reviews was set");
        this.reviews = reviews;
    }

    public void setRating(Rating rating) {
        LOGGER.trace("rating was set");
        this.rating = rating;
    }

    public void setTitle(String title) {
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        LOGGER.trace("title was set");
        this.title = title;
    }

    public void setDescription(String description) {
        LOGGER.trace("desc was set");
        this.description = description;
    }

    public void setOrdersCount(int ordersCount) {
        if(ordersCount < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
        LOGGER.trace("orders count was set");
        this.ordersCount = ordersCount;
    }

    public void setProducts(List<Product> products) {
        LOGGER.trace("products was set");
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return rating == shop.rating && ordersCount == shop.ordersCount
                && Objects.equals(title, shop.title) && Objects.equals(description, shop.description)
                && Objects.equals(reviews, shop.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, reviews, rating, ordersCount);
    }

    @Override
    public String toString() {
        return  title + '-' + description + "; Rating: " + rating;
    }
}
