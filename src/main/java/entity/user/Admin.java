package entity.user;

import entity.enums.Rating;
import entity.enums.Role;
import entity.enums.UserStatus;
import entity.goods.Product;
import entity.enums.ProductTypes;
import entity.goods.Shop;
import entity.interfaces.IRule;
import org.apache.log4j.Logger;

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

    public void blockUser(User user) {
        user.setStatus(UserStatus.BLOCKED);
        LOGGER.info("user " + user.getName() + " " + user.getSurname() + "is blocked");
        if(user instanceof Manager) {
            LOGGER.info("manager " + user.getName() + " " + user.getSurname() + "loosed manager rights");
            setManagerRights((Manager) user, false);
        }
    }

    public void unblockUser(User user) {
        user.setStatus(UserStatus.BLOCKED);
        LOGGER.info("user " + user.getName() + " " + user.getSurname() + "is unblocked");
    }

    @Override
    public void setManagerRights(Manager manager, boolean value) {
        manager.setProcessRights(value);
    }

    public Shop createShop(String title, String description, Rating rating, int ordersCount){
        LOGGER.info("new shop created");
        return new Shop(title, description, rating, ordersCount);
    }

    public Product createProduct(String title, Rating rating, double price, int count,
                                 String description, ProductTypes type, Shop shop) {
        Product product = new Product(title, rating, price, count, description, type);
        shop.addProduct(product);
        LOGGER.info("new product created");
        return product;
    }

    public boolean deleteProduct(Product product, Shop shop) {
        if(shop.deleteProduct(product)){
            LOGGER.info("product was deleted");
            return true;
        }
        LOGGER.warn("product wasn't deleted");
        return false;
    }

    public boolean isRightsForProduct() {
        return rightsForProduct;
    }

    public boolean isRightsForShop() {
        return rightsForShop;
    }

    public boolean isRightsForStatus() {
        return rightsForStatus;
    }

    public void setRightsForProduct(boolean rightsForProduct) {
        this.rightsForProduct = rightsForProduct;
    }

    public void setRightsForShop(boolean rightsForShop) {
        this.rightsForShop = rightsForShop;
    }

    public void setRightsForStatus(boolean rightsForStatus) {
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
