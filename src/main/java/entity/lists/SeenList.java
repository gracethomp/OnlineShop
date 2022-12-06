package entity.lists;

import entity.goods.Product;
import entity.interfaces.IOrderBy;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SeenList extends ListForUsers implements IOrderBy {
    private LocalDate dateFrom;

    private static final Logger LOGGER = Logger.getLogger(SeenList.class);

    public SeenList(){}
    public SeenList(LocalDate dateFrom){
        this.dateFrom = dateFrom;
    }

    public List<Product> orderByPrice() {
        Comparator<Product> comparator = Comparator.comparing(Product::getPrice);
        getProducts().sort(comparator);
        LOGGER.debug("Products in seen list order by price");
        return getProducts();
    }

    public List<Product> orderByTitle() {
        Comparator<Product> comparator = Comparator.comparing(Product::getTitle);
        getProducts().sort(comparator);
        LOGGER.debug("Products in seen list order by title");
        return getProducts();
    }

    public LocalDate getDateFrom() {
        LOGGER.trace("date from was gotten");
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        LOGGER.trace("date from was set");
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
