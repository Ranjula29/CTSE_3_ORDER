package com.ctse.order.service;

import com.ctse.order.model.Order;
import com.ctse.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderServiceInt {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void createOrder(Order order) {

        try{
            float amount = order.getProductPrice() * order.getQuantity();
            order.setAmount(amount);
            orderRepository.save(order);

        }catch (Exception e){

            throw new RuntimeException("error getting the save order " + e);

        }
    }

    @Override
    public List<Order> getAllOrders() {
        try {
            return orderRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("error getting list of order " + e);
        }
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        try {
            Optional<Order> order = orderRepository.findById(id);
            return order;
        } catch (Exception e) {
            throw new RuntimeException("error getting find a single order " + e);
        }
    }

    @Override
    public boolean updateOrder(Order order, String id) {
        try {
            Optional<Order> order1 = orderRepository.findById(id);
            if (order1 == null) {
                return false;
            } else {
                Order order2 = order1.get();
                order2.setQuantity(order.getQuantity());
                order2.setDeliveryAddress(order.getDeliveryAddress());
                order2.setRecipientName(order.getRecipientName());
                float amount = order.getProductPrice() * order.getQuantity();
                order2.setAmount(amount);

                orderRepository.save(order2);
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException("error getting update order " + e);
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            if (id == null) {
                return false;
            } else {
                orderRepository.deleteById(id);
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException("error getting delete order " + e);
        }
    }
}
