package com.example.orderservice.service;

import com.example.orderservice.dto.RequestOrder;
import com.example.orderservice.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDbService {
    private OrderRepository orderRepository;
    @Autowired
    public OrderDbService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String saveOrder(RequestOrder order){
        return orderRepository.save(order).getOrderId();
    }
}
