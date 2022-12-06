package entity.lists;

import exceptions.OnlineShopEmptyTitleException;
import exceptions.OnlineShopNullPointerException;
import org.apache.log4j.Logger;

import java.util.Objects;

public class WishList extends ListForUsers {
    private String title;

    private static final Logger LOGGER = Logger.getLogger(WishList.class);

    public WishList() {}
    public WishList(String title) {
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        this.title = title;
    }

    public String getTitle() {
        LOGGER.trace("title was gotten");
        return title;
    }

    public void setTitle(String title) {
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        LOGGER.trace("title was set");
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishList wishList = (WishList) o;
        return Objects.equals(title, wishList.title) && super.equals(wishList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title);
    }

    @Override
    public String toString() {
        return "WishList title is" + title + '\n' + super.toString();
    }

}
