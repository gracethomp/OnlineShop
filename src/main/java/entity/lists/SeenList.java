package entity.lists;

import entity.Product;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SeenList extends ListForUsers {
    private LocalDate dateFrom;

    public SeenList(){}
    public SeenList(List<Product> products, LocalDate dateFrom){
        this.dateFrom = dateFrom;
    }

    public List<Product> orderByPrice() {
        Comparator<Product> comparator = Comparator.comparing(Product::getPrice);
        getProducts().sort(comparator);
        return getProducts();
    }
    public List<Product> orderByTitle() {
        Comparator<Product> comparator = Comparator.comparing(Product::getTitle);
        getProducts().sort(comparator);
        return getProducts();
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SeenList seenList = (SeenList) o;
        return Objects.equals(dateFrom, seenList.dateFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateFrom);
    }

    @Override
    public String toString() {
        return "This is seen list. Products: " + super.toString();
    }
}
