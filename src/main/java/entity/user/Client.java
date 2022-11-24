package entity.user;

import entity.*;
import entity.lists.SeenList;
import entity.lists.WishList;
import entity.user.staff.ClothingSizes;
import entity.user.staff.MailingList;
import entity.user.staff.PaymentCard;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private String country;
    private String city;
    private String streetTitle;
    private int streetNumber;
    private int appartmentNumber;
    private ShopBasket shopBasket;
    private MailingList mailingList;
    private PaymentCard card;
    private ClothingSizes clothingSizes;
    private List<WishList> wishLists;
    private SeenList seenList;
    private List<Stock> stocks;
    private List<Order> orders;

    public Client() {}

    public Client(String name, String surname, String email, String password, String phoneNumber,
                  String country, String city, String streetTitle, int streetNumber, int appartmentNumber,
                  ShopBasket shopBasket, MailingList mailingList, PaymentCard card,
                  ClothingSizes clothingSizes, SeenList seenList) {
        super(name, surname, email, password, Role.CLIENT, phoneNumber);
        this.country = country;
        this.city = city;
        this.streetTitle = streetTitle;
        this.streetNumber = streetNumber;
        this.appartmentNumber = appartmentNumber;
        this.shopBasket = shopBasket;
        this.mailingList = mailingList;
        this.card = card;
        this.clothingSizes = clothingSizes;
        this.seenList = seenList;
        this.wishLists = new ArrayList<>();
        this.stocks = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public boolean addOrder(Order order){
        return orders.add(order);
    }

    public boolean createWishList(WishList wishList) {
        return wishLists.add(wishList);
    }

    public String getCountry() {
        return country;
    }

    public ClothingSizes getClothingSizes() {
        return clothingSizes;
    }

    public int getAppartmentNumber() {
        return appartmentNumber;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public List<WishList> getWishLists() {
        return wishLists;
    }

    public MailingList getMailingList() {
        return mailingList;
    }

    public PaymentCard getCard() {
        return card;
    }

    public SeenList getSeenList() {
        return seenList;
    }

    public ShopBasket getShopBasket() {
        return shopBasket;
    }

    public String getCity() {
        return city;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getStreetTitle() {
        return streetTitle;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAppartmentNumber(int appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public void setCard(PaymentCard card) {
        this.card = card;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMailingList(MailingList mailingList) {
        this.mailingList = mailingList;
    }

    public void setClothingSizes(ClothingSizes clothingSizes) {
        this.clothingSizes = clothingSizes;
    }

    public void setSeenList(SeenList seenList) {
        this.seenList = seenList;
    }

    public void setShopBasket(ShopBasket shopBasket) {
        this.shopBasket = shopBasket;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetTitle(String streetTitle) {
        this.streetTitle = streetTitle;
    }

    public void setWishLists(List<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
