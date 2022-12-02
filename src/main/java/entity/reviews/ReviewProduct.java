package entity.reviews;

import enums.Rating;
import entity.goods.Product;
import entity.goods.Shop;
import entity.user.User;

import java.util.Objects;

public class ReviewProduct extends Review {
    private Shop shop;
    private Product product;

    public ReviewProduct(){}
    public ReviewProduct(String comment, Rating rating, Shop shop, User user, Product product) {
        super(comment, rating, user);
        this.shop = shop;
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public Product getProduct() {
        return product;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setProduct(Product product) {
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
