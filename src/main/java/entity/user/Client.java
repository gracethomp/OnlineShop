package entity.user;

import entity.*;
import entity.lists.SeenList;
import entity.lists.WishList;
import entity.user.staff.ClothingSizes;
import entity.user.staff.MailingList;
import entity.user.staff.PaymentCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Client(String name, String surname, String email, String password, String phoneNumber, String status,
                  String country, String city, String streetTitle, int streetNumber, int appartmentNumber,
                  ShopBasket shopBasket, MailingList mailingList, PaymentCard card,
                  ClothingSizes clothingSizes, SeenList seenList) {
        super(name, surname, email, password, Role.CLIENT, phoneNumber, status);
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

    public boolean deleteCard() {
        if(card.getCVV() != 0 && card.getMonth() != 0 && card.getNumber() != 0 && card.getYear() != 0) {
            card = new PaymentCard();
            return true;
        }
        else
            return false;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return super.equals(o) && streetNumber == client.streetNumber
                && appartmentNumber == client.appartmentNumber
                && Objects.equals(country, client.country) && Objects.equals(city, client.city)
                && Objects.equals(streetTitle, client.streetTitle) &&
                Objects.equals(shopBasket, client.shopBasket) && Objects.equals(mailingList, client.mailingList)
                && Objects.equals(card, client.card) && Objects.equals(clothingSizes, client.clothingSizes)
                && Objects.equals(wishLists, client.wishLists) && Objects.equals(seenList, client.seenList)
                && Objects.equals(stocks, client.stocks) && Objects.equals(orders, client.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country, city, streetTitle, streetNumber,
                appartmentNumber, shopBasket, mailingList, card, clothingSizes, wishLists, seenList, stocks, orders);
    }

    @Override
    public String toString() {
        return super.toString() + ", country: " + country +
                " city: " + city +
                ", address: " + streetTitle + " " + streetNumber + ", " + appartmentNumber +
                "\n" + shopBasket +
                "\n" + mailingList +
                "\n" + card +
                "\n" + clothingSizes +
                "\n" + wishLists +
                ", seenList=" + seenList +
                ", stocks=" + stocks +
                ", orders=" + orders;
    }
}
