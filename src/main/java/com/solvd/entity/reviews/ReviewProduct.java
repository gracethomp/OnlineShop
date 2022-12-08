package com.solvd.entity.reviews;

import com.solvd.entity.enums.Rating;
import com.solvd.entity.goods.Product;
import com.solvd.entity.goods.Shop;
import com.solvd.entity.user.User;
import org.apache.log4j.Logger;

import java.util.Objects;

public class ReviewProduct extends Review {
    private Shop shop;
    private Product product;

    private static final Logger LOGGER = Logger.getLogger(ReviewProduct.class);

    public ReviewProduct(){}
    public ReviewProduct(String comment, Rating rating, Shop shop, User user, Product product) {
        super(comment, rating, user);
        this.shop = shop;
        this.product = product;
    }

    public Shop getShop() {
        LOGGER.trace("shop was gotten");
        return shop;
    }

    public Product getProduct() {
        LOGGER.trace("product was gotten");
        return product;
    }

    public void setShop(Shop shop) {
        LOGGER.trace("shop was set");
        this.shop = shop;
    }

    public void setProduct(Product product) {
        LOGGER.trace("product was set");
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewProduct that = (ReviewProduct) o;
        return Objects.equals(shop, that.shop) && Objects.equals(product, that.product) && super.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shop, product);
    }

    @Override
    public String toString() {
        return "ReviewProduct{" +
                "shop=" + shop +
                ", product=" + product +
                '}' + super.toString();
    }
}
