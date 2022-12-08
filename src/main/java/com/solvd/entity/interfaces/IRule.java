package com.solvd.entity.interfaces;

import com.solvd.entity.goods.Product;
import com.solvd.entity.goods.Shop;
import com.solvd.entity.user.Manager;
import com.solvd.entity.user.User;
import com.solvd.exceptions.OnlineShopIOException;

public interface IRule extends IManage {
    void blockUser(User user);

    void unblockUser(User user);

    void setManagerRights(Manager manager, boolean value);

    Shop createShop(Shop shop) throws OnlineShopIOException;

    Product createProduct(Product product, Shop shop) throws OnlineShopIOException;

    boolean deleteProduct(Product product, Shop shop);

}
