package entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    //private Client client;
    private List<Product> products;
    private String recipientName;
    private String recipientSurname;
    private String location;
    private String post;
    private double totalPrice;
    private String wayToPay;
    private String promocode;
    private String status;
    public Order() {}
    public Order(String recipientName, String recipientSurname, String location,
                 String post, double totalPrice, String wayToPay, String promocode, String status) {
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

    public String getWayToPay() {
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

    public void setWayToPay(String wayToPay) {
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
}
