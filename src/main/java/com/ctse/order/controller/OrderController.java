package com.ctse.order.controller;

import com.ctse.order.model.Order;
import com.ctse.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;


    //endpoint for register
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return order;
    }

    //endpoint get all
    @GetMapping("/orders")
    public List<Order> orders() {
        return orderService.getAllOrders();
    }

    //endpoint for get single
    @GetMapping("/order")
    public Optional<Order> product(@RequestParam String id) {
        return orderService.getOrderById(id);
    }

    // endpoint for update
    @PutMapping("/orders/{id}")
    public boolean editUser(@PathVariable String id, @RequestBody Order order) {
        return orderService.updateOrder(order, id);
    }

    // endpoint for delete
    @DeleteMapping("orders/{id}")
    public boolean delete(@PathVariable String id) {
        return orderService.delete(id);
    }


}
