package entity.reviews;

import entity.lists.WishList;
import entity.user.User;
import entity.enums.Rating;
import org.apache.log4j.Logger;

public abstract class Review {
    private String comment;
    private Rating rating;
    private User user;

    private static final Logger LOGGER = Logger.getLogger(Review.class);

    public Review(){}
    public Review(String comment, Rating rating, User user) {
        this.comment = comment;
        this.rating = rating;
        this.user = user;
    }

    public Rating getRating() {
        LOGGER.trace("rating was gotten");
        return rating;
    }

    public String getComment() {
        LOGGER.trace("comment was gotten");
        return comment;
    }

    public User getUser() {
        LOGGER.trace("user was gotten");
        return user;
    }

    public void setComment(String comment) {
        LOGGER.trace("comment was set");
        this.comment = comment;
    }

    public void setRating(Rating rating) {
        LOGGER.trace("rating was set");
        this.rating = rating;
    }

    public void setUser(User user) {
        LOGGER.trace("user was set");
        this.user = user;
    }

    @Override
    public String toString() {
        return comment + "Stars: " + rating + "User: " + user;
    }
}
