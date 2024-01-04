package com.example.orderservice.repo;

import com.example.orderservice.dto.RequestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<RequestOrder, Integer> {

}
