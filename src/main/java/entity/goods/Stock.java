package entity.goods;

import entity.enums.ProductTypes;
import entity.reviews.Review;
import entity.interfaces.IComment;
import exceptions.OnlineShopEmptyTitleException;
import exceptions.OnlineShopNegativeValuesException;
import exceptions.OnlineShopNullPointerException;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stock implements IComment {
    private String title;
    private int discount;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private ProductTypes productType;
    private String description;
    private List<Review> reviews;

    private static final Logger LOGGER = Logger.getLogger(Stock.class);

    public Stock(){}
    public Stock(String title, int discount, LocalDate dateFrom,
                 LocalDate dateTo, ProductTypes productType, String description) {
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        if(discount < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
        this.title = title;
        this.discount = discount;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.productType = productType;
        this.description = description;
        this.reviews = new ArrayList<>();
    }

    @Override
    public boolean addReview(Review review) {
        LOGGER.debug(review + "was added");
        return reviews.add(review);
    }

    public String getTitle() {
        LOGGER.trace("title was gotten");
        return title;
    }

    public String getDescription() {
        LOGGER.trace("desc was gotten");
        return description;
    }

    public int getDiscount() {
        LOGGER.trace("discount was gotten");
        return discount;
    }

    public LocalDate getDateFrom() {
        LOGGER.trace("date from was gotten");
        return dateFrom;
    }

    public LocalDate getDateTo() {
        LOGGER.trace("date to was gotten");
        return dateTo;
    }

    public ProductTypes getProductType() {
        LOGGER.trace("product type was gotten");
        return productType;
    }

    public void setTitle(String title) {
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        if(title.equals("")){
            LOGGER.error(OnlineShopEmptyTitleException.EMPTY_TITLE_MESSAGE);
            throw new OnlineShopEmptyTitleException();
        }
        LOGGER.trace("title was set");
        this.title = title;
    }

    public void setDescription(String description) {
        LOGGER.trace("desc was set");
        this.description = description;
    }

    public void setDateFrom(LocalDate dateFrom) {
        LOGGER.trace("date from was set");
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo) {
        LOGGER.trace("date to was set");
        this.dateTo = dateTo;
    }

    public void setDiscount(int discount) {
        if(discount < 0) {
            LOGGER.error(OnlineShopNegativeValuesException.NEGATIVE_VALUE_MESSAGE);
            throw new OnlineShopNegativeValuesException();
        }
        LOGGER.trace("discount was set");
        this.discount = discount;
    }

    public void setProductType(ProductTypes productType) {
        LOGGER.trace("product type was set");
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return discount == stock.discount && Objects.equals(title, stock.title)
                && Objects.equals(dateFrom, stock.dateFrom) && Objects.equals(dateTo, stock.dateTo)
                && Objects.equals(productType, stock.productType) && Objects.equals(description, stock.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, discount, dateFrom, dateTo, productType, description);
    }

    @Override
    public String toString() {
        return "Stock title is" + title +
                ", discount " + discount + "%, Time: " + dateFrom + "-" +
                dateTo + ", Product types, included to stock: " + productType +
                ", description: " + description;
    }
}
