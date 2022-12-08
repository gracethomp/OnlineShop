package com.solvd.entity.user.stuff;

import com.solvd.entity.enums.OrderStatus;
import com.solvd.entity.goods.Product;
import com.solvd.entity.enums.WaysToPay;
import com.solvd.entity.user.Client;
import com.solvd.entity.user.Manager;
import com.solvd.entity.interfaces.Calculable;
import com.solvd.exceptions.OnlineShopNegativeValuesException;
import org.apache.log4j.Logger;

import java.util.List;

public class ShopBasket implements Calculable {
    private List<Product> products;
    private double totalPrice;

    private static final Logger LOGGER = Logger.getLogger(ShopBasket.class);

    public ShopBasket(){}
    public ShopBasket(double totalPrice){
        if(totalPrice < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
    }

    @Override
    public double calculateTotalPrice() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        LOGGER.debug("total price is " + sum + " without delivery");
        return sum;
    }

    public double calculateTotalPrice(double delivery) {
        double sum = calculateTotalPrice();
        sum += delivery;
        LOGGER.debug("total price is " + sum + " without delivery");
        return sum;

    }
    public void formOrder(Client client, String recipientName, String recipientSurname, String location,
                          String post, double totalPrice, WaysToPay wayToPay, Manager manager) {
        Order order = new Order(recipientName, recipientSurname, location, post,
                totalPrice, wayToPay, OrderStatus.REGISTERED);
        manager.addOrderToProcess(order);
        client.addOrder(order);
        LOGGER.info("new order was formed");
    }

    public void formOrder(Client client, String recipientName, String recipientSurname, String location,
                          String post, double totalPrice, WaysToPay wayToPay, String promocode, Manager manager) {
        Order order = new Order(recipientName, recipientSurname, location, post,
                totalPrice, wayToPay, promocode, OrderStatus.REGISTERED);
        manager.addOrderToProcess(order);
        client.addOrder(order);
        LOGGER.info("new order was formed with promocode");
    }

    public boolean addProduct(Product product) {
        LOGGER.debug(product + " was added");
        return products.add(product);
    }

    public double getTotalPrice() {
        LOGGER.trace("total price was gotten");
        return totalPrice;
    }

    public List<Product> getProducts() {
        LOGGER.trace("products were gotten");
        return products;
    }

    public void setProducts(List<Product> products) {
        LOGGER.trace("products were set");
        this.products = products;
    }

    public void setTotalPrice(double totalPrice) {
        if(totalPrice < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
        LOGGER.trace("total price was set");
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ShopBasket has the next products: " + products +
                "and totalPrice " + totalPrice;
    }
}
