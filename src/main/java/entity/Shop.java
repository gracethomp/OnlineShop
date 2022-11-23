package entity;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String title;
    private String description;
    private List<Review> reviews;
    private int rating;
    private int ordersCount;
    public Shop() {}
    public Shop(String title, String description, int rating, int ordersCount){
        this.reviews = new ArrayList<>();
        this.title = title;
    }
    public void addReview(Review review) {
        reviews.add(review);
    }
}
