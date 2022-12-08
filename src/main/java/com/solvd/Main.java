package com.solvd;

import com.solvd.entity.enums.OrderStatus;
import com.solvd.entity.enums.Role;
import com.solvd.entity.enums.WaysToPay;
import com.solvd.entity.interfaces.IManage;
import com.solvd.entity.user.Admin;
import com.solvd.entity.user.Client;
import com.solvd.entity.user.Manager;
import com.solvd.entity.user.User;
import com.solvd.entity.user.stuff.ClothingSizes;
import com.solvd.entity.user.stuff.Order;
import com.solvd.linkedList.MyLinkedList;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        LinkedList<String> strings = new LinkedList<>();
        strings.add("1 string");
        strings.add("2 string");
        strings.add("3 string");
        strings.addFirst("4 string");
        strings.addLast("5 string");
        LOGGER.info(strings);

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("1 string");
        myLinkedList.add("2 string");
        myLinkedList.add("3 string");
        LOGGER.info(myLinkedList);
        myLinkedList.remove("2 string");
        LOGGER.info(myLinkedList);

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
                System.out.println(Admin.ORDER_PROCESSED_BY_ADMIN);
                System.out.println(Manager.ORDER_ACCEPTED);
                continue;
            }
            e.acceptOrder(order, client);
            System.out.println(Manager.ORDER_ACCEPTED);
        }

        //polymorphism with abstract class
        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(client);
        users.add(manager);
        users.add(admin);
        users.add(admin);
        users.add(client);
        for (User u : users) {
            System.out.println(u.getRole());
        }
    }
}
