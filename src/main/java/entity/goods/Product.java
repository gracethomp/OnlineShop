package entity.goods;

import entity.enums.Rating;
import entity.enums.ProductTypes;
import entity.enums.WaysToPay;
import entity.reviews.Review;
import entity.reviews.ReviewProduct;
import entity.interfaces.IComment;
import exceptions.OnlineShopEmptyTitleException;
import exceptions.OnlineShopNegativeValuesException;
import exceptions.OnlineShopNullPointerException;
import org.apache.log4j.Logger;

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

    private static final Logger LOGGER = Logger.getLogger(Product.class);

    public Product(){}
    public Product(String title, Rating rating, double price, int count, String description, ProductTypes type) {
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        if(count < 0 || price < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
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
        LOGGER.debug(way + " was added");
        return waysToPay.add(way);
    }

    public boolean deleteWayToPay(WaysToPay way) {
        if(waysToPay.contains(way)) {
            LOGGER.debug("one of ways to pay (" + way + ") was deleted");
            return waysToPay.remove(way);
        }
        LOGGER.warn("way not found");
        return false;
    }

    public void reduceCount(int countOrdered) {
        if(countOrdered <= 0) {
            LOGGER.error("User chose illegal count of products");
            throw new OnlineShopNegativeValuesException();
        }
        if((count - countOrdered) < 0) {
            LOGGER.error("User chose more products than possible");
            throw new OnlineShopNegativeValuesException();
        }
        count -= countOrdered;
        LOGGER.info("reduce was successful");
    }

    @Override
    public boolean addReview(Review review) {
        if(review instanceof ReviewProduct) {
            if (((ReviewProduct) review).getShop().addReview(review)) {
                if (((ReviewProduct) review).getProduct().addReview(review)) {
                    LOGGER.debug(review + " is added to product");
                    return reviews.add(review);
                }
            }
        }
        LOGGER.warn("Review adding to product is wrong");
        return false;
    }

    public String getTitle() {
        LOGGER.trace("title was gotten");
        return title;
    }

    public Rating getRating() {
        LOGGER.trace("rating was gotten");
        return rating;
    }

    public double getPrice() {
        LOGGER.trace("rating was gotten");
        return price;
    }

    public String getDescription() {
        LOGGER.trace("description was gotten");
        return description;
    }

    public List<Review> getReviews() {
        LOGGER.trace("reviews was gotten");
        return reviews;
    }

    public int getCount() {
        LOGGER.trace("count was gotten");
        return count;
    }

    public ProductTypes getType() {
        LOGGER.trace("type was gotten");
        return type;
    }

    public List<WaysToPay> getWaysToPay() {
        LOGGER.trace("ways to pay was gotten");
        return waysToPay;
    }

    public void setDescription(String description) {
        LOGGER.trace("description was set");
        this.description = description;
    }

    public void setTitle(String title) {
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        LOGGER.trace("title was set");
        this.title = title;
    }

    public void setRating(Rating rating) {
        LOGGER.trace("rating was set");
        this.rating = rating;
    }

    public void setReviews(List<Review> reviews) {
        LOGGER.trace("reviews was set");
        this.reviews = reviews;
    }

    public void setPrice(double price) {
        if(price < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
        LOGGER.trace("price was set");
        this.price = price;
    }

    public void setCount(int count) {
        if(count < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
        LOGGER.trace("count was set");
        this.count = count;
    }

    public void setType(ProductTypes type) {
        LOGGER.trace("type was set");
        this.type = type;
    }

    public void setWaysToPay(List<WaysToPay> waysToPay) {
        LOGGER.trace("ways to pay was set");
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
