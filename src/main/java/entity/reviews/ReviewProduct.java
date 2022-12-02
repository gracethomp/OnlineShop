package entity.reviews;

import entity.enums.Rating;
import entity.goods.Product;
import entity.goods.Shop;
import entity.user.User;

import java.util.Objects;

public class ReviewProduct extends Review {
    private Shop shop;
    private User user;
    private Product product;

    public ReviewProduct(){}
    public ReviewProduct(String comment, Rating rating, Shop shop, User user, Product product) {
        super(comment, rating);
        this.shop = shop;
        this.user = user;
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewProduct that = (ReviewProduct) o;
        return Objects.equals(shop, that.shop) && Objects.equals(user, that.user)
                && Objects.equals(product, that.product) && super.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shop, user, product);
    }

    @Override
    public String toString() {
        return "ReviewProduct{" +
                "shop=" + shop +
                ", user=" + user +
                ", product=" + product +
                '}' + super.toString();
    }
}
