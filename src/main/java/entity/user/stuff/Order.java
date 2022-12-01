package entity.user.stuff;

import entity.goods.Product;
import entity.enums.WaysToPay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private List<Product> products;
    private String recipientName;
    private String recipientSurname;
    private String location;
    private String post;
    private double totalPrice;
    private WaysToPay wayToPay;
    private String promocode;
    private String status;
    public Order() {}
    public Order(String recipientName, String recipientSurname, String location,
                 String post, double totalPrice, WaysToPay wayToPay, String status){
        this.recipientName = recipientName;
        this.recipientSurname = recipientSurname;
        this.location = location;
        this.post = post;
        this.totalPrice = totalPrice;
        this.wayToPay = wayToPay;
        this.status = status;
        this.products = new ArrayList<>();
    }
    public Order(String recipientName, String recipientSurname, String location,
                 String post, double totalPrice, WaysToPay wayToPay, String promocode, String status) {
        this.recipientName = recipientName;
        this.recipientSurname = recipientSurname;
        this.location = location;
        this.post = post;
        this.totalPrice = totalPrice;
        this.wayToPay = wayToPay;
        this.promocode = promocode;
        this.status = status;
        this.products = new ArrayList<>();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public WaysToPay getWayToPay() {
        return wayToPay;
    }

    public String getPost() {
        return post;
    }

    public String getLocation() {
        return location;
    }

    public String getPromocode() {
        return promocode;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getRecipientSurname() {
        return recipientSurname;
    }

    public String getStatus() {
        return status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setWayToPay(WaysToPay wayToPay) {
        this.wayToPay = wayToPay;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public void setRecipientSurname(String recipientSurname) {
        this.recipientSurname = recipientSurname;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order has the next products: " + products +
                "\n The recipient full name: '" + recipientName + " " + recipientSurname +
                ", location: " + location +
                ", post: " + post +
                ", totalPrice: " + totalPrice +
                ", wayToPay: " + wayToPay +
                ", promocode: " + promocode +
                ", status: " + status ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.totalPrice, totalPrice) == 0 &&
                Objects.equals(products, order.products) &&
                Objects.equals(recipientName, order.recipientName) &&
                Objects.equals(recipientSurname, order.recipientSurname) &&
                Objects.equals(location, order.location) && Objects.equals(post, order.post)
                && Objects.equals(wayToPay, order.wayToPay) && Objects.equals(promocode, order.promocode)
                && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, recipientName, recipientSurname,
                location, post, totalPrice, wayToPay, promocode, status);
    }
}
