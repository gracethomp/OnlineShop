package com.solvd.entity.interfaces;

import com.solvd.entity.user.Client;
import com.solvd.entity.user.stuff.Order;

public interface IManage {
    boolean acceptOrder(Order order, Client client);

    boolean cancelOrder(Order order, Client client);

}
