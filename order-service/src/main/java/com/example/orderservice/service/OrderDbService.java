package com.example.orderservice.service;

import com.example.orderservice.dto.RequestOrder;
import com.example.orderservice.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDbService {
    @Autowired
    private OrderRepository orderRepository;

    public String saveOrder(RequestOrder order){
        return orderRepository.save(order).getOrderId();
    }
}
