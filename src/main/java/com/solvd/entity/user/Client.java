package com.solvd.entity.user;

import com.solvd.entity.enums.Role;
import com.solvd.entity.enums.UserStatus;
import com.solvd.entity.goods.Stock;
import com.solvd.entity.lists.SeenList;
import com.solvd.entity.lists.WishList;
import com.solvd.entity.interfaces.Calculable;
import com.solvd.entity.user.stuff.*;
import com.solvd.exceptions.OnlineShopNegativeValuesException;
import com.solvd.exceptions.PaymentCardIllegalArgumentException;
import com.solvd.lambda.IGet;
import org.apache.log4j.Logger;

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

    private static final Logger LOGGER = Logger.getLogger(Client.class);

    public Client() {}
    public Client(String name, String surname, String email, String password, String phoneNumber, UserStatus status,
                  String country, String city, String streetTitle, int streetNumber, int apartmentNumber,
                  ShopBasket shopBasket, MailingList mailingList, PaymentCard card,
                  ClothingSizes clothingSizes, SeenList seenList) {
        super(name, surname, email, password, phoneNumber, status);
        if(streetNumber < 0 || apartmentNumber < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
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
        LOGGER.trace("order added");
        return getOrders().add(order);
    }

    public void deleteCard() {
        if(card.getCVV() != 0 && card.getMonth() != 0 && card.getNumber() != 0 && card.getYear() != 0) {
            LOGGER.debug("card deleted " + card);
            card = new PaymentCard();
        }
        else {
            LOGGER.error("card can't be deleted because of troubles in data");
            throw new PaymentCardIllegalArgumentException();
        }
    }

    public boolean createWishList(WishList wishList) {
        LOGGER.debug(wishList + " was added");
        return wishLists.add(wishList);
    }

    @Override
    public double calculateTotalPrice(IGet summarize) {
        double sum = getOrders().stream().mapToDouble(Order::getTotalPrice).sum();
        LOGGER.debug("total price is " + sum + " without delivery");
        return sum;
    }

    public String getCountry() {
        LOGGER.trace("country was gotten");
        return country;
    }

    public ClothingSizes getClothingSizes() {
        LOGGER.trace("clothing sizes was gotten");
        return clothingSizes;
    }

    public int getApartmentNumber() {
        LOGGER.trace("apartment number was gotten");
        return apartmentNumber;
    }

    public int getStreetNumber() {
        LOGGER.trace("street number was gotten");
        return streetNumber;
    }

    public List<Stock> getStocks() {
        LOGGER.trace("country was gotten");
        return stocks;
    }

    public List<WishList> getWishLists() {
        LOGGER.trace("wish lists were gotten");
        return wishLists;
    }

    public MailingList getMailingList() {
        LOGGER.trace("mailing list was gotten");
        return mailingList;
    }

    public PaymentCard getCard() {
        LOGGER.trace("payment card was gotten");
        return card;
    }

    public SeenList getSeenList() {
        LOGGER.trace("seen list was gotten");
        return seenList;
    }

    public ShopBasket getShopBasket() {
        LOGGER.trace("shop basket was gotten");
        return shopBasket;
    }

    public String getCity() {
        LOGGER.trace("city was gotten");
        return city;
    }

    public String getStreetTitle() {
        LOGGER.trace("street title was gotten");
        return streetTitle;
    }

    public void setCountry(String country) {
        LOGGER.trace("country was set");
        this.country = country;
    }

    public void setApartmentNumber(int apartmentNumber) {
        if(apartmentNumber < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
        LOGGER.trace("apartment was set");
        this.apartmentNumber = apartmentNumber;
    }

    public void setCard(PaymentCard card) {
        LOGGER.trace("card was set");
        this.card = card;
    }

    public void setCity(String city) {
        LOGGER.trace("city was set");
        this.city = city;
    }

    public void setMailingList(MailingList mailingList) {
        LOGGER.trace("mailing list was set");
        this.mailingList = mailingList;
    }

    public void setClothingSizes(ClothingSizes clothingSizes) {
        LOGGER.trace("clothing sizes was set");
        this.clothingSizes = clothingSizes;
    }

    public void setSeenList(SeenList seenList) {
        LOGGER.trace("seen list was set");
        this.seenList = seenList;
    }

    public void setShopBasket(ShopBasket shopBasket) {
        LOGGER.trace("shop basket was set");
        this.shopBasket = shopBasket;
    }

    public void setStocks(List<Stock> stocks) {
        LOGGER.trace("stocks were set");
        this.stocks = stocks;
    }

    public void setStreetNumber(int streetNumber) {
        if(streetNumber < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
        LOGGER.trace("street number was set");
        this.streetNumber = streetNumber;
    }

    public void setStreetTitle(String streetTitle) {
        LOGGER.trace("street title was set");
        this.streetTitle = streetTitle;
    }

    public void setWishLists(List<WishList> wishLists) {
        LOGGER.trace("wish list was set");
        this.wishLists = wishLists;
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
                && Objects.equals(wishLists, client.wishLists) && Objects.equals(seenList, client.seenList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country, city, streetTitle, streetNumber,
                apartmentNumber, shopBasket, mailingList, card, clothingSizes, wishLists, seenList, stocks);
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
                ", stocks=" + stocks;
    }

}
