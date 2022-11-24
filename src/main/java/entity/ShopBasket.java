package entity;

import entity.user.Client;
import entity.user.Manager;

import java.util.List;

public class ShopBasket {
    private List<Product> products;
    private double totalPrice;

    public double calculateTotalPrice() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void formOrder(Client client, String recipientName, String recipientSurname, String location,
                          String post, double totalPrice, String wayToPay, Manager manager) {
        Order order = new Order();
        order.setRecipientName(recipientName);
        order.setRecipientSurname(recipientSurname);
        order.setLocation(location);
        order.setPost(post);
        order.setTotalPrice(totalPrice);
        order.setWayToPay(wayToPay);
        order.setStatus("registered");
        manager.addOrderToProcess(order);
        client.addOrder(order);
    }

    public void formOrder(Client client, String recipientName, String recipientSurname, String location,
                          String post, double totalPrice, String wayToPay, String promocode, Manager manager) {
        Order order = new Order(recipientName, recipientSurname, location, post,
                totalPrice, wayToPay, promocode, "registered");
        manager.addOrderToProcess(order);
        client.addOrder(order);
    }

    public double calculateTotalPrice(double delivery) {
        double sum = calculateTotalPrice();
        return sum + delivery;
    }
    public boolean addProduct(Product product) {
        return products.add(product);
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ShopBasket has the next products: " + products +
                "and totalPrice " + totalPrice;
    }
}
