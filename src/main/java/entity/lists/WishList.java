package entity.lists;

public class WishList extends ListForUsers {
    String title;
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
}
