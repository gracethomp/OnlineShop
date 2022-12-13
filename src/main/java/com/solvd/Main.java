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
import java.util.List;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        LOGGER.info(myLinkedList.get(7));
        myLinkedList.add("1 string");
        myLinkedList.add("2 string");
        myLinkedList.add("3 string");
        LOGGER.info(myLinkedList);
        myLinkedList.remove("2 string");
        myLinkedList.add("3 string", "4 string");
        LOGGER.info(myLinkedList);
        LOGGER.info(myLinkedList.getSize());
        myLinkedList.add(2, "5 string");
        myLinkedList.add(2, "5 string");
        myLinkedList.add(2, "5 string");
        myLinkedList.add(3, "6 string");
        myLinkedList.add(0, "7 string");
        myLinkedList.add(7, "8 string");
        myLinkedList.addToFront("9 string");
        LOGGER.info(myLinkedList.get(7));
        LOGGER.info(myLinkedList);
        LOGGER.info(myLinkedList.getSize());

        for (int i = myLinkedList.getSize(); i >= 0; i--) {
            LOGGER.info(myLinkedList.get(i));
        }

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
        for (User u : users) {
            LOGGER.info(u.getRole());
        }
    }
}
