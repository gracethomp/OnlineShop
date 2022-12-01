import entity.enums.OrderStatus;
import entity.enums.UserStatus;
import entity.enums.WaysToPay;
import entity.user.Admin;
import entity.user.Client;
import entity.user.Manager;
import entity.user.interfaces.IManage;
import entity.user.stuff.Order;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("Grace", "Thompson", "Kyiv",
                "Nova Poshta 5", 6000, WaysToPay.CASH, OrderStatus.REGISTERED);
        Order order1 = new Order("Tom", "Thompson", "Kyiv",
                "Nova Poshta 5", 6400, WaysToPay.CASH, OrderStatus.REGISTERED);
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

        for (IManage e: manageList) {
            e.acceptOrder(order, client);
        }
    }
}
