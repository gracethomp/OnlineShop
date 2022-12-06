package entity.reviews;

import entity.user.User;
import entity.enums.Rating;
import entity.goods.Stock;
import org.apache.log4j.Logger;

import java.util.Objects;

public class ReviewStock extends Review {
    private Stock stock;

    private static final Logger LOGGER = Logger.getLogger(ReviewProduct.class);

    public ReviewStock(){
        LOGGER.info("new review created");
    }
    public ReviewStock(String comment, Rating rating, User user, Stock stock) {
        super(comment, rating, user);
        this.stock = stock;
    }

    public Stock getStock() {
        LOGGER.trace("stock was gotten");
        return stock;
    }

    public void setStock(Stock stock) {
        LOGGER.trace("stock was set");
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewStock that = (ReviewStock) o;
        return Objects.equals(stock, that.stock) && super.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stock);
    }

    @Override
    public String toString() {
        return super.toString() +"ReviewStock{" +
                "stock=" + stock +
                '}';
    }
}
