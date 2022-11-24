package entity;

import java.util.List;

public class Product {
    private String title;
    private int rating;
    private double price;
    private Shop shop;
    private int count;
    private String description;
    private String type;
    private List<Review> reviews;
    private List<String> waysToPay;
    public Product(){}
    public Product(String title, int rating, double price, Shop shop, int count, String description, String type) {
        this.title = title;
        this.rating = rating;
        this.price = price;
        this.shop = shop;
        this.count = count;
        this.description = description;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
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

    public Shop getShop() {
        return shop;
    }

    public String getType() {
        return type;
    }

    public List<String> getWaysToPay() {
        return waysToPay;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(int rating) {
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

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWaysToPay(List<String> waysToPay) {
        this.waysToPay = waysToPay;
    }
}
