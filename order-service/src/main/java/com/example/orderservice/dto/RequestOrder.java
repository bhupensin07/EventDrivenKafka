package com.example.orderservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="OrderTable")
public class RequestOrder {
    @Id
    private String orderId;
    private String name;
    private int qty;
    private double price;
}
