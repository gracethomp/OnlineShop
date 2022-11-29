package entity.user;

import entity.Product;
import entity.Shop;

public class Admin extends User implements IManage {

    public Admin(){}

    public Admin(String name, String surname, String email,
                 String password, String phoneNumber, String status) {
        super(name, surname, email, password, Role.ADMIN, phoneNumber, status);
    }

    public void blockUser(User user) {
        user.setStatus("blocked");
    }

    public void unblockUser(User user) {
        user.setStatus("ok");
    }

    public Shop createShop(String title, String description, int rating, int ordersCount){
        return new Shop(title, description, rating, ordersCount);
    }

    public Product createProduct(String title, int rating, double price, int count,
                                 String description, String type, Shop shop) {
        Product product = new Product(title, rating, price, count, description, type);
        shop.addProduct(product);
        return product;
    }

    public boolean deleteProduct(Product product, Shop shop) {
        return shop.deleteProduct(product);
    }
}
