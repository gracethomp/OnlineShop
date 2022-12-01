package entity.user;

import entity.enums.OrderStatus;
import entity.enums.Role;
import entity.enums.UserStatus;
import entity.user.interfaces.IManage;
import entity.user.stuff.Order;

import java.util.List;
import java.util.Objects;

public class Manager extends User implements IManage {
    private boolean processRights;

    public Manager(){}
    public Manager(String name, String surname, String email, String password,
                   String phoneNumber, UserStatus status, boolean rightsManager, Role role){
        super(name, surname, email, password, phoneNumber, status);
        setRole(role);
        this.processRights = rightsManager;
    }

    public boolean addOrderToProcess(Order order) {
        return getOrders().add(order);
    }

    @Override
    public boolean acceptOrder(Order order, Client client) {
        if(getOrders().contains(order) && client.getOrders().contains(order)) {
            int index = client.getOrders().indexOf(order);
            client.getOrders().get(index).setStatus(OrderStatus.IN_PROGRESS);
            if(getOrders().remove(order)) {
                System.out.println("order accepted\n");
                return true;
            }
        }
        System.out.println("order not accepted\n");
        return false;
    }

    @Override
    public boolean cancelOrder(Order order, Client client) {
        if(getOrders().contains(order) && client.getOrders().contains(order)) {
            int index = client.getOrders().indexOf(order);
            client.getOrders().get(index).setStatus(OrderStatus.CANCELLED);
            if(getOrders().remove(order)) {
                System.out.println("order cancelled");
                return true;
            }
        }
        return false;
    }

    public boolean isProcessRights() {
        return processRights;
    }

    public void setProcessRights(boolean processRights) {
        this.processRights = processRights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return super.equals(manager) && processRights == manager.processRights;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), processRights);
    }

    @Override
    public String toString() {
        return super.toString() + "Manager{" +
                "processRights=" + processRights +
                '}';
    }
}
