package entity.reviews;

import entity.user.User;
import enums.Rating;

public abstract class Review {
    private String comment;
    private Rating rating;
    private User user;

    public Review(){}
    public Review(String comment, Rating rating, User user) {
        this.comment = comment;
        this.rating = rating;
        this.user = user;
    }

    public Rating getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return comment + "Stars: " + rating + "User: " + user;
    }
}
