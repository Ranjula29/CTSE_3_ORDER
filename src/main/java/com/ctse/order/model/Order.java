package com.ctse.order.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Order {

    @Id
    private String id;
    private String userId;
    private String productId;
    private float productPrice;
    private int quantity;
    private String deliveryAddress;
    private String recipientName;
    private float amount;

}
