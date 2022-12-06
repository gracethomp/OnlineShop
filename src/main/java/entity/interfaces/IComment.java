package entity.interfaces;

import entity.reviews.Review;
import exceptions.OnlineShopIOException;

public interface IComment {
    boolean addReview(Review review) throws OnlineShopIOException;
}
