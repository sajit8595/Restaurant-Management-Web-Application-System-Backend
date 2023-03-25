package com.restaurant.restaurantmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.restaurantmanagement.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    // void deleteByName(String name);
    
}
