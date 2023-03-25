package com.restaurant.restaurantmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.restaurantmanagement.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
