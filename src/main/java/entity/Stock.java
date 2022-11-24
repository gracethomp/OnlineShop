package entity;

import java.time.LocalDate;

public class Stock {
    private String title;
    private int discount;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String productType;
    private String description;
    public Stock(){}
    public Stock(String title, int discount, LocalDate dateFrom,
                 LocalDate dateTo, String productType, String description) {
        this.title = title;
        this.discount = discount;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.productType = productType;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDiscount() {
        return discount;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public String getProductType() {
        return productType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
