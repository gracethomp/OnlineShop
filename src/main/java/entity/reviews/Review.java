package entity.reviews;

public abstract class Review {
    private String comment;
    private int rating;

    public Review(){}
    public Review(String comment, int rating) {
        this.comment = comment;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return comment + "Stars: " + rating;
    }
}
