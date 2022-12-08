package com.solvd.entity.user;

import com.solvd.entity.enums.Role;
import com.solvd.entity.enums.UserStatus;
import com.solvd.entity.goods.Product;
import com.solvd.entity.goods.Shop;
import com.solvd.entity.interfaces.IRule;
import com.solvd.exceptions.OnlineShopIOException;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Admin extends Manager implements IRule {
    public static final String ORDER_PROCESSED_BY_ADMIN = "order processed by admin";

    private boolean rightsForStatus;
    private boolean rightsForShop;
    private boolean rightsForProduct;

    private static final Logger LOGGER = Logger.getLogger(Admin.class);

    public Admin(){}
    public Admin(String name, String surname, String email, String password,
                 String phoneNumber, UserStatus status, boolean rightsForStatus,
                 boolean rightsForShop, boolean rightsForProduct, boolean rightsManager) {
        super(name, surname, email, password, phoneNumber, status, rightsManager, Role.ADMIN);
        this.rightsForStatus = rightsForStatus;
        this.rightsForShop = rightsForShop;
        this.rightsForProduct = rightsForProduct;
    }

    @Override
    public void blockUser(User user) {
        user.setStatus(UserStatus.BLOCKED);
        LOGGER.info("user " + user.getName() + " " + user.getSurname() + "is blocked");
        if(user instanceof Manager) {
            LOGGER.info("manager " + user.getName() + " " + user.getSurname() + "loosed manager rights");
            setManagerRights((Manager) user, false);
        }
    }

    @Override
    public void unblockUser(User user) {
        user.setStatus(UserStatus.BLOCKED);
        LOGGER.info("user " + user.getName() + " " + user.getSurname() + "is unblocked");
    }

    @Override
    public void setManagerRights(Manager manager, boolean value) {
        manager.setProcessRights(value);
    }

    @Override
    public Shop createShop(Shop shop) throws OnlineShopIOException {
        try{
            FileWriter fileWriter = new FileWriter(Shop.fileName);
            fileWriter.write(shop.toString());
        } catch (IOException e) {
            LOGGER.error(OnlineShopIOException.SHOP_IO_EXCEPTION, e);
            throw new OnlineShopIOException(OnlineShopIOException.SHOP_IO_EXCEPTION, e);
        }
        LOGGER.debug("new shop created " + shop);
        return shop;
    }
    @Override
    public Product createProduct(Product product, Shop shop) throws OnlineShopIOException {
        try{
            FileWriter fileWriter = new FileWriter(Product.fileName);
            fileWriter.write(shop.toString());
        } catch (IOException e) {
            LOGGER.error(OnlineShopIOException.SHOP_IO_EXCEPTION);
            throw new OnlineShopIOException(OnlineShopIOException.SHOP_IO_EXCEPTION, e);
        }
        shop.addProduct(product);
        LOGGER.debug("new product created " + product);
        return product;
    }
    @Override
    public boolean deleteProduct(Product product, Shop shop) {
        if(shop.deleteProduct(product)){
            LOGGER.info("product was deleted");
            return true;
        }
        LOGGER.warn("product wasn't deleted");
        return false;
    }

    public boolean isRightsForProduct() {
        LOGGER.trace("rights for product was checked");
        return rightsForProduct;
    }

    public boolean isRightsForShop() {
        LOGGER.trace("rights for shop was checked");
        return rightsForShop;
    }

    public boolean isRightsForStatus() {
        LOGGER.trace("rights for status was checked");
        return rightsForStatus;
    }

    public void setRightsForProduct(boolean rightsForProduct) {
        LOGGER.trace("rights for product was set");
        this.rightsForProduct = rightsForProduct;
    }

    public void setRightsForShop(boolean rightsForShop) {
        LOGGER.trace("rights for shop was set");
        this.rightsForShop = rightsForShop;
    }

    public void setRightsForStatus(boolean rightsForStatus) {
        LOGGER.trace("rights for status was checked");
        this.rightsForStatus = rightsForStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return super.equals(admin) && rightsForStatus == admin.rightsForStatus
                && rightsForShop == admin.rightsForShop && rightsForProduct == admin.rightsForProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rightsForStatus, rightsForShop, rightsForProduct);
    }

    @Override
    public String toString() {
        return super.toString() + "Admin{" +
                "rightsForStatus=" + rightsForStatus +
                ", rightsForShop=" + rightsForShop +
                ", rightsForProduct=" + rightsForProduct +
                '}';
    }
}
