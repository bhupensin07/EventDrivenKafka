package com.example.orderservice.controller;

import com.example.basedomains.dto.Order;
import com.example.basedomains.dto.OrderEvent;
import com.example.orderservice.dto.RequestOrder;
import com.example.orderservice.kafka.OrderProducer;
import com.example.orderservice.service.OrderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderProducer orderProducer;
    @Autowired
    private OrderDbService orderDbService;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order Status is in Pending status");
        orderEvent.setOrder(order);

        String id = orderDbService.saveOrder(convertDto(order));
        orderProducer.sendMessage(orderEvent);
        return "Order Placed Successfully with Id: "+id;
    }
    private RequestOrder convertDto(Order order){
        RequestOrder dbOrder = new RequestOrder();
        dbOrder.setOrderId(order.getOrderId());
        dbOrder.setName(order.getName());
        dbOrder.setQty(order.getQty());
        dbOrder.setPrice(order.getPrice());
        return dbOrder;
    }
}
