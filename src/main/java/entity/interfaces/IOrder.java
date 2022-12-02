package entity.interfaces;

import entity.goods.Product;

import java.util.List;

public interface IOrder {
    List<Product> orderByPrice();
    List<Product> orderByTitle();
}
