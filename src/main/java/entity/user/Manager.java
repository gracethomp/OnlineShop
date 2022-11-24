package entity.user;

import entity.Order;

public class Manager extends User implements Management {

    public Manager(){}
    public Manager(String name, String surname, String email, String password, String phoneNumber, String status){
        super(name, surname, email, password, Role.MANAGER, phoneNumber, status);
    }

    public boolean addOrderToProcess(Order order) {
        return getOrders().add(order);
    }
}
