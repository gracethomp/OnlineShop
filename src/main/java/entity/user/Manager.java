package entity.user;

import entity.user.interfaces.IManage;
import entity.user.stuff.Order;

import java.util.Objects;

public class Manager extends User implements IManage {
    private boolean processRights;

    public Manager(){}
    public Manager(String name, String surname, String email, String password,
                   String phoneNumber, String status, boolean rightsManager){
        super(name, surname, email, password, Role.MANAGER, phoneNumber, status);
        this.processRights = rightsManager;
    }

    public boolean addOrderToProcess(Order order) {
        return getOrders().add(order);
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
