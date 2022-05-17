package com.ctse.order.service;

import com.ctse.order.model.Order;


import java.util.List;
import java.util.Optional;

public interface OrderServiceInt {
    void createOrder(Order order);

    public List<Order> getAllOrders();

    public Optional<Order> getOrderById(String id);

    public boolean updateOrder(Order order, String id);

    public boolean delete(String id);


}
