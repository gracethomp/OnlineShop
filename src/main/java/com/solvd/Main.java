package com.solvd;

import com.solvd.entity.enums.OrderStatus;
import com.solvd.entity.enums.Role;
import com.solvd.entity.enums.WaysToPay;
import com.solvd.entity.goods.Catalog;
import com.solvd.entity.goods.Product;
import com.solvd.entity.interfaces.IManage;
import com.solvd.entity.user.Admin;
import com.solvd.entity.user.Client;
import com.solvd.entity.user.Manager;
import com.solvd.entity.user.User;
import com.solvd.entity.user.stuff.ClothingSizes;
import com.solvd.entity.user.stuff.Order;
import com.solvd.entity.user.stuff.ShopBasket;
import com.solvd.linkedList.MyLinkedList;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        WordsCounter.countWords("src/main/resources/text.txt");

        MyLinkedList.testLinkedList();

        ClothingSizes.printSizesInfo();
        System.out.println('\n');

        //polymorphism with interface
        Order order = new Order("Grace", "Thompson", "Kiev",
                "Nova Post 5", 6000, WaysToPay.CASH, OrderStatus.REGISTERED);

        Admin admin = new Admin();
        admin.setRole(Role.ADMIN);
        Client client = new Client();
        client.setRole(Role.CLIENT);
        Manager manager = new Manager();
        manager.setRole(Role.MANAGER);

        client.getOrders().add(order);
        client.getOrders().add(order);
        admin.getOrders().add(order);
        manager.getOrders().add(order);

        List<IManage> manageList = new ArrayList<>();

        manageList.add(admin);
        manageList.add(new Manager());
        manageList.add(manager);

        for (IManage e : manageList) {
            if (e instanceof Admin && e.acceptOrder(order, client)) {
                LOGGER.info(Admin.ORDER_PROCESSED_BY_ADMIN);
                LOGGER.info(Manager.ORDER_ACCEPTED);
                continue;
            }
            e.acceptOrder(order, client);
            LOGGER.info(Manager.ORDER_ACCEPTED);
        }

        //polymorphism with abstract class
        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(client);
        users.add(manager);
        users.add(admin);
        users.add(admin);
        users.add(client);
        for (User u : users)
            LOGGER.info(u.getRole());
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

        try {
            Class<?> c = Class.forName("com.solvd.entity.user.Admin");
            Constructor<?>[] constructor = c.getConstructors();
            Field[] fields = c.getDeclaredFields();
            Method[] methods = c.getMethods();
            Arrays.stream(fields).toList().forEach(LOGGER::info);
            System.out.println();
            Arrays.stream(constructor).toList().forEach(LOGGER::info);
            System.out.println();
            Arrays.stream(methods).toList().forEach(LOGGER::info);
            Class<?> cSuperclass = c.getSuperclass();
            System.out.println();
            LOGGER.info(cSuperclass.getName());
            Object v = c.getConstructor().newInstance();
            LOGGER.info(v);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.error(e);
        }
    }
}
