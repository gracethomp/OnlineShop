package entity.interfaces;

import entity.enums.Rating;
import entity.goods.Product;
import entity.enums.ProductTypes;
import entity.goods.Shop;
import entity.user.Manager;
import entity.user.User;
import exceptions.OnlineShopIOException;

public interface IRule extends IManage {
    void blockUser(User user);

    void unblockUser(User user);

    void setManagerRights(Manager manager, boolean value);

    Shop createShop(String title, String description, Rating rating, int ordersCount) throws OnlineShopIOException;

    Product createProduct(String title, Rating rating, double price, int count,
                          String description, ProductTypes type, Shop shop);

    boolean deleteProduct(Product product, Shop shop);

}
