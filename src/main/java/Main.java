import entity.enums.OrderStatus;
import entity.enums.WaysToPay;
import entity.user.Admin;
import entity.user.Client;
import entity.user.Manager;
import entity.user.interfaces.IManage;
import entity.user.stuff.ClothingSizes;
import entity.user.stuff.Order;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClothingSizes.printSizesInfo();
        System.out.println('\n');
        Order order = new Order("Grace", "Thompson", "Kiev",
                "Nova Posta 5", 6000, WaysToPay.CASH, OrderStatus.REGISTERED);

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
            if(e instanceof Admin && e.acceptOrder(order, client)) {
                System.out.println(Admin.ORDER_PROCESSED_BY_ADMIN);
                System.out.println(Manager.ORDER_ACCEPTED);
                continue;
            }
            e.acceptOrder(order, client);
            System.out.println(Manager.ORDER_ACCEPTED);
        }
    }
}
