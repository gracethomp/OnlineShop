package com.solvd.entity.interfaces;

import com.solvd.entity.reviews.Review;
import com.solvd.exceptions.OnlineShopIOException;

public interface IComment {
    boolean addReview(Review review) throws OnlineShopIOException;
}
