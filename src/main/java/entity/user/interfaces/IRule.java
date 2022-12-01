package entity.user.interfaces;

import entity.goods.Product;
import entity.goods.Shop;
import entity.user.Admin;
import entity.user.Manager;
import entity.user.User;
import entity.user.interfaces.IManage;

public interface IRule extends IManage {
    void blockUser(User user);
    void unblockUser(User user);
    void setManagerRights(Manager manager, boolean value);
    Shop createShop(String title, String description, int rating, int ordersCount);
    Product createProduct(String title, int rating, double price, int count,
                          String description, String type, Shop shop);
    boolean deleteProduct(Product product, Shop shop);
}
