package entity.lists;

import java.util.Objects;

public class WishList extends ListForUsers {
    private String title;
    public WishList() {}
    public WishList(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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
