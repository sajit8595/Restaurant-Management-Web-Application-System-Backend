package com.restaurant.restaurantmanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.restaurantmanagement.entities.*;


public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    
}
