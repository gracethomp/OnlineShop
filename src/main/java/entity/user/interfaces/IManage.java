package entity.user.interfaces;

import entity.enums.OrderStatus;
import entity.user.Client;
import entity.user.stuff.Order;

import java.util.List;

public interface IManage {
    boolean acceptOrder(Order order, Client client);

    boolean cancelOrder(Order order, Client client);

}
