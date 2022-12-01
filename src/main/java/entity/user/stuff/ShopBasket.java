package entity.user.stuff;

import entity.enums.OrderStatus;
import entity.goods.Product;
import entity.enums.WaysToPay;
import entity.user.Client;
import entity.user.Manager;
import entity.user.interfaces.Calculable;

import java.util.List;

public class ShopBasket implements Calculable {
    private List<Product> products;
    private double totalPrice;

    public double calculateTotalPrice() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }
    public double calculateTotalPrice(double delivery) {
        double sum = calculateTotalPrice();
        return sum + delivery;
    }
    public void formOrder(Client client, String recipientName, String recipientSurname, String location,
                          String post, double totalPrice, WaysToPay wayToPay, Manager manager) {
        Order order = new Order(recipientName, recipientSurname, location, post,
                totalPrice, wayToPay, OrderStatus.REGISTERED);
        manager.addOrderToProcess(order);
        client.addOrder(order);
    }

    public void formOrder(Client client, String recipientName, String recipientSurname, String location,
                          String post, double totalPrice, WaysToPay wayToPay, String promocode, Manager manager) {
        Order order = new Order(recipientName, recipientSurname, location, post,
                totalPrice, wayToPay, promocode, OrderStatus.REGISTERED);
        manager.addOrderToProcess(order);
        client.addOrder(order);
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
