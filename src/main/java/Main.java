import entity.enums.OrderStatus;
import entity.enums.Role;
import entity.enums.WaysToPay;
import entity.interfaces.IManage;
import entity.user.Admin;
import entity.user.Client;
import entity.user.Manager;
import entity.user.User;
import entity.user.stuff.ClothingSizes;
import entity.user.stuff.Order;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Main {
    private static Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.error("graceTHOM");
        //static method
        ClothingSizes.printSizesInfo();
        System.out.println('\n');

        //polymorphism with interface
        Order order = new Order("Grace", "Thompson", "Kiev",
                "Nova Posta 5", 6000, WaysToPay.CASH, OrderStatus.REGISTERED);

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
