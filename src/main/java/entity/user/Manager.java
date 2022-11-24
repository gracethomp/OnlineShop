package entity.user;

import entity.Order;

import java.util.ArrayList;
import java.util.List;

public class Manager extends User {
    private List<Order> ordersToProcess;

    public Manager(){}
    public Manager(String name, String surname, String email, String password, String phoneNumber){
        super(name, surname, email, password, Role.MANAGER, phoneNumber);
        ordersToProcess = new ArrayList<>();
    }

    public boolean addOrderToProcess(Order order) {
        return ordersToProcess.add(order);
    }

    public boolean acceptOrder(Order order, Client client) {
        if(ordersToProcess.contains(order) && client.getOrders().contains(order)) {
            int index = client.getOrders().indexOf(order);
            client.getOrders().get(index).setStatus("accepted");
            return ordersToProcess.remove(order);
        }
        else
            return false;
    }

    public boolean cancelOrder(Order order, Client client) {
        if(ordersToProcess.contains(order) && client.getOrders().contains(order)) {
            int index = client.getOrders().indexOf(order);
            client.getOrders().get(index).setStatus("cancelled");
            return ordersToProcess.remove(order);
        }
        else
            return false;
    }

    /*public void editOrder(Order order, Client client) {
        //
    }*/

    public List<Order> getOrdersToProcess() {
        return ordersToProcess;
    }

    public void setOrdersToProcess(List<Order> ordersToProcess) {
        this.ordersToProcess = ordersToProcess;
    }
}
