package entity.user;

import enums.Role;
import enums.UserStatus;
import entity.goods.Stock;
import entity.lists.SeenList;
import entity.lists.WishList;
import entity.user.interfaces.Calculable;
import entity.user.stuff.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client extends User implements Calculable {
    private String country;
    private String city;
    private String streetTitle;
    private int streetNumber;
    private int apartmentNumber;
    private ShopBasket shopBasket;
    private MailingList mailingList;
    private PaymentCard card;
    private ClothingSizes clothingSizes;
    private List<WishList> wishLists = new ArrayList<>();
    private SeenList seenList;
    private List<Stock> stocks = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public Client() {}

    public Client(String name, String surname, String email, String password, String phoneNumber, UserStatus status,
                  String country, String city, String streetTitle, int streetNumber, int apartmentNumber,
                  ShopBasket shopBasket, MailingList mailingList, PaymentCard card,
                  ClothingSizes clothingSizes, SeenList seenList) {
        super(name, surname, email, password, phoneNumber, status);
        this.country = country;
        this.city = city;
        this.streetTitle = streetTitle;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.shopBasket = shopBasket;
        this.mailingList = mailingList;
        this.card = card;
        this.clothingSizes = clothingSizes;
        this.seenList = seenList;
        setRole(Role.CLIENT);
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

    @Override
    public double calculateTotalPrice() {
        return orders.stream().mapToDouble(Order::getTotalPrice).sum();
    }

    public String getCountry() {
        return country;
    }

    public ClothingSizes getClothingSizes() {
        return clothingSizes;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
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

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
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
                && apartmentNumber == client.apartmentNumber
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
                apartmentNumber, shopBasket, mailingList, card, clothingSizes, wishLists, seenList, stocks, orders);
    }

    @Override
    public String toString() {
        return super.toString() + ", country: " + country +
                " city: " + city +
                ", address: " + streetTitle + " " + streetNumber + ", " + apartmentNumber +
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
