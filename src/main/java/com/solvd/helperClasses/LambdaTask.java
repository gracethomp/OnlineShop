package com.solvd.helperClasses;

import com.solvd.entity.goods.Catalog;
import com.solvd.entity.goods.Product;
import com.solvd.entity.user.stuff.Order;
import com.solvd.entity.user.stuff.ShopBasket;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class LambdaTask {
    private static final Logger LOGGER = Logger.getLogger(LambdaTask.class);

    public static void showLambdaTask(){
        List<Product> products = new ArrayList<>();
        for (int i = 100; i < 1000; i += 100) {
            Product product = new Product();
            product.setTitle("phone");
            product.setPrice(i);
            products.add(product);
        }
        ShopBasket shopBasket = new ShopBasket();
        shopBasket.setProducts(products);
        shopBasket.calculateTotalPrice(Product::getPrice);

        Product p = new Product();
        p.setTitle("book");
        products.add(p);
        p = new Product();
        p.setTitle("game");
        products.add(p);
        Catalog catalog = new Catalog();
        catalog.setProducts(products);
        LOGGER.info(catalog.search(p1 -> p1.getTitle().equals("book")));

        Order order1 = new Order();
        order1.setId(103);
        order1.deliverOrder(((deliveryMessage, itemToDeliver) -> deliveryMessage + itemToDeliver),
                "new item is in progress, id ");
    }
}
