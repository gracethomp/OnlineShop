package entity.goods;

import entity.enums.Rating;
import entity.enums.ProductTypes;
import entity.enums.WaysToPay;
import entity.reviews.Review;
import entity.reviews.ReviewProduct;
import entity.user.interfaces.IComment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product implements IComment {
    private String title;
    private Rating rating;
    private double price;
    private int count;
    private String description;
    private ProductTypes type;
    private List<Review> reviews;
    private List<WaysToPay> waysToPay;
    public Product(){}
    public Product(String title, Rating rating, double price, int count, String description, ProductTypes type) {
        this.title = title;
        this.rating = rating;
        this.price = price;
        this.count = count;
        this.description = description;
        this.type = type;
        this.reviews = new ArrayList<>();
        this.waysToPay = new ArrayList<>();
    }

    public boolean addWayToPay(WaysToPay way) {
        return waysToPay.add(way);
    }

    public boolean deleteWayToPay(String way) {
        return waysToPay.remove(way);
    }

    public boolean reduceCount(int countOrdered) {
        if(countOrdered <= 0)
            return false;
        if((count - countOrdered) < 0)
            throw new IllegalArgumentException();
        count -= countOrdered;
        return true;
    }

    @Override
    public boolean addReview(Review review) {
        if(review instanceof ReviewProduct)
            if(((ReviewProduct) review).getShop().addReview(review))
                if(((ReviewProduct) review).getProduct().addReview(review))
                    return reviews.add(review);
        return false;
    }

    public String getTitle() {
        return title;
    }

    public Rating getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public int getCount() {
        return count;
    }

    public ProductTypes getType() {
        return type;
    }

    public List<WaysToPay> getWaysToPay() {
        return waysToPay;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setType(ProductTypes type) {
        this.type = type;
    }

    public void setWaysToPay(List<WaysToPay> waysToPay) {
        this.waysToPay = waysToPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return rating == product.rating && Double.compare(product.price, price) == 0
                && count == product.count && Objects.equals(title, product.title)
                && Objects.equals(description, product.description) && Objects.equals(type, product.type)
                && Objects.equals(reviews, product.reviews) && Objects.equals(waysToPay, product.waysToPay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, rating, price, count, description, type, reviews, waysToPay);
    }

}
