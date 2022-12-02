package entity.interfaces;

import entity.user.Client;
import entity.user.stuff.Order;

public interface IManage {
    boolean acceptOrder(Order order, Client client);

    boolean cancelOrder(Order order, Client client);

}
