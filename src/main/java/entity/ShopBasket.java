package entity;

import java.util.List;

public class ShopBasket {
    private List<Product> products;
    private double totalPrice;

    public double calculateTotalPrice() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }

    public double calculateTotalPrice(double delivery) {
        double sum = calculateTotalPrice();
        return sum + delivery;
    }
    public boolean addProduct(Product product) {
        return products.add(product);
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
