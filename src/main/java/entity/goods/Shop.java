package entity.goods;

import entity.reviews.Review;
import entity.user.interfaces.IComment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shop implements IComment {
    private String title;
    private String description;
    private List<Review> reviews;
    private int rating;
    private int ordersCount;
    private List<Product> products;

    public Shop() {}
    public Shop(String title, String description, int rating, int ordersCount){
        this.reviews = new ArrayList<>();
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.ordersCount = ordersCount;
        this.products = new ArrayList<>();
    }
    public boolean addReview(Review review) {
        return reviews.add(review);
    }

    public boolean addProduct(Product product){
        return products.add(product);
    }

    public boolean deleteProduct(Product product) {
        return products.remove(product);
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public int getRating() {
        return rating;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public void setProducts(List<Product> products) {
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
