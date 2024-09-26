package com.shreyas.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.microservices.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
