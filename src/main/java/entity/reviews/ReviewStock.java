package entity.reviews;

import entity.user.User;
import entity.enums.Rating;
import entity.goods.Stock;

import java.util.Objects;

public class ReviewStock extends Review {
    private Stock stock;
    public String g;

    public ReviewStock(){}
    public ReviewStock(String comment, Rating rating, User user, Stock stock) {
        super(comment, rating, user);
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
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
