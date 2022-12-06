package entity.user.stuff;

import entity.enums.OrderStatus;
import entity.goods.Product;
import entity.enums.WaysToPay;
import exceptions.NotMatchRegexException;
import exceptions.OnlineShopNegativeValuesException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private static final String NAME_SURNAME_REGEX = "[a-zA-Z]{2,20}";

    private List<Product> products;
    private String recipientName;
    private String recipientSurname;
    private String location;
    private String post;
    private double totalPrice;
    private WaysToPay wayToPay;
    private String promocode;
    private OrderStatus status;

    private static final Logger LOGGER = Logger.getLogger(Order.class);

    public Order() {}
    public Order(String recipientName, String recipientSurname, String location,
                 String post, double totalPrice, WaysToPay wayToPay, OrderStatus status){
        if(!recipientName.matches(NAME_SURNAME_REGEX) && !recipientSurname.matches(NAME_SURNAME_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_FULL_NAME);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_FULL_NAME);
        }
        if(totalPrice < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
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
                 String post, double totalPrice, WaysToPay wayToPay, String promocode, OrderStatus status) {
        if(totalPrice < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
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
        LOGGER.trace("total price was gotten");
        return totalPrice;
    }

    public WaysToPay getWayToPay() {
        LOGGER.trace("way to pay was gotten");
        return wayToPay;
    }

    public String getPost() {
        LOGGER.trace("post was gotten");
        return post;
    }

    public String getLocation() {
        LOGGER.trace("location was gotten");
        return location;
    }

    public String getPromocode() {
        LOGGER.trace("promocode was gotten");
        return promocode;
    }

    public String getRecipientName() {
        LOGGER.trace("recipient name was gotten");
        return recipientName;
    }

    public String getRecipientSurname() {
        LOGGER.trace("recipient surname was gotten");
        return recipientSurname;
    }

    public OrderStatus getStatus() {
        LOGGER.trace("status was gotten");
        return status;
    }

    public List<Product> getProducts() {
        LOGGER.trace("products were gotten");
        return products;
    }

    public void setTotalPrice(double totalPrice) {
        if(totalPrice < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
        LOGGER.trace("total price was gotten");
        this.totalPrice = totalPrice;
    }

    public void setWayToPay(WaysToPay wayToPay) {
        LOGGER.trace("way to pay was set");
        this.wayToPay = wayToPay;
    }

    public void setLocation(String location) {
        LOGGER.trace("location was set");
        this.location = location;
    }

    public void setPost(String post) {
        LOGGER.trace("post was set");
        this.post = post;
    }

    public void setPromocode(String promocode) {
        LOGGER.trace("promocode was set");
        this.promocode = promocode;
    }

    public void setRecipientName(String recipientName) {
        if(!recipientName.matches(NAME_SURNAME_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_FULL_NAME);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_FULL_NAME);
        }
        LOGGER.trace("recipient name was set");
        this.recipientName = recipientName;
    }

    public void setRecipientSurname(String recipientSurname) {
        if(!recipientSurname.matches(NAME_SURNAME_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_FULL_NAME);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_FULL_NAME);
        }
        LOGGER.trace("recipient surname was set");
        this.recipientSurname = recipientSurname;
    }

    public void setProducts(List<Product> products) {
        LOGGER.trace("products were set");
        this.products = products;
    }

    public void setStatus(OrderStatus status) {
        LOGGER.trace("status was set");
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
