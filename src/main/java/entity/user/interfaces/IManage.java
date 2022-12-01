package entity.user.interfaces;

import entity.user.Client;
import entity.user.stuff.Order;

import java.util.List;

public interface IManage {
    default boolean acceptOrder(Order order, Client client, List<Order> ordersToProcess) {
        if(ordersToProcess.contains(order) && client.getOrders().contains(order)) {
            int index = client.getOrders().indexOf(order);
            client.getOrders().get(index).setStatus("accepted");
            return ordersToProcess.remove(order);
        }
        else
            return false;
    }

    default boolean cancelOrder(Order order, Client client, List<Order> ordersToProcess) {
        if(ordersToProcess.contains(order) && client.getOrders().contains(order)) {
            int index = client.getOrders().indexOf(order);
            client.getOrders().get(index).setStatus("cancelled");
            return ordersToProcess.remove(order);
        }
        else
            return false;
    }

}
