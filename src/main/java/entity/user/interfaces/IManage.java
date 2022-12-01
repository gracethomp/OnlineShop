package entity.user.interfaces;

import entity.enums.OrderStatus;
import entity.user.Client;
import entity.user.stuff.Order;

import java.util.List;

public interface IManage {
    default boolean acceptOrder(Order order, Client client, List<Order> ordersToProcess) {
        if(ordersToProcess.contains(order) && client.getOrders().contains(order)) {
            int index = client.getOrders().indexOf(order);
            client.getOrders().get(index).setStatus(OrderStatus.IN_PROGRESS);
            return ordersToProcess.remove(order);
        }
        else
            return false;
    }

    default boolean cancelOrder(Order order, Client client, List<Order> ordersToProcess) {
        if(ordersToProcess.contains(order) && client.getOrders().contains(order)) {
            int index = client.getOrders().indexOf(order);
            client.getOrders().get(index).setStatus(OrderStatus.CANCELLED);
            return ordersToProcess.remove(order);
        }
        else
            return false;
    }

}
