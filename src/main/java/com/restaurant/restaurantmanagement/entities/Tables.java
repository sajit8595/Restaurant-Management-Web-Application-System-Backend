package com.restaurant.restaurantmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tables")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean booked;
    private int customerId;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean getBooked() {
        return booked;
    }
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    
    public Tables() {
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public Tables(int id, boolean booked, int customerId) {
        this.id = id;
        this.booked = booked;
        this.customerId = customerId;
    }

    
}