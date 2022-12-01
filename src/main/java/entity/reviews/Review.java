package entity.reviews;

import entity.enums.Rating;

public abstract class Review {
    private String comment;
    private Rating rating;

    public Review(){}
    public Review(String comment, Rating rating) {
        this.comment = comment;
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return comment + "Stars: " + rating;
    }
}
