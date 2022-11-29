package entity;

import entity.user.User;

public class ReviewProduct extends Review{
    private Shop shop;
    private User user;
    private Product product;

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
}
