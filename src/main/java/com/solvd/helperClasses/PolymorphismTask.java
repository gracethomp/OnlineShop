package com.solvd.helperClasses;

import com.solvd.Main;
import com.solvd.entity.enums.OrderStatus;
import com.solvd.entity.enums.Role;
import com.solvd.entity.enums.WaysToPay;
import com.solvd.entity.interfaces.IManage;
import com.solvd.entity.user.Admin;
import com.solvd.entity.user.Client;
import com.solvd.entity.user.Manager;
import com.solvd.entity.user.User;
import com.solvd.entity.user.stuff.Order;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class PolymorphismTask {
    private static final Logger LOGGER = Logger.getLogger(PolymorphismTask.class);

    public static void showPolymorphismInterfaceExample(){
        Order order = new Order("Grace", "Thompson", "Kiev",
                "Nova Post 5", 6000, WaysToPay.CASH, OrderStatus.REGISTERED);

        Admin admin = new Admin();
        Client client = new Client();
        Manager manager = new Manager();

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
    }
    public static void showPolymorphismClassExample(){
        Admin admin = new Admin();
        admin.setRole(Role.ADMIN);
        Client client = new Client();
        client.setRole(Role.CLIENT);
        Manager manager = new Manager();
        manager.setRole(Role.MANAGER);

        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(client);
        users.add(manager);
        users.add(admin);
        users.add(admin);
        users.add(client);
        for (User u : users)
            LOGGER.info(u.getRole());
    }
}
