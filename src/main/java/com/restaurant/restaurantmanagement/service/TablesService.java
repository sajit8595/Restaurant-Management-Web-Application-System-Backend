package com.restaurant.restaurantmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.restaurantmanagement.entities.Customer;
import com.restaurant.restaurantmanagement.entities.Tables;
import com.restaurant.restaurantmanagement.repository.TablesRepository;




@Service
public class TablesService {
   
   @Autowired
   private TablesRepository repo;


    
   @Autowired
   private CustomerService customerService;

   public Tables saveTable(Tables table){
      return repo.save(table);
   }

   public List<Tables> getAllTables(){
      return repo.findAll();
   }

   public Tables getById(int id){
      return repo.findById(id).orElse(null);
   }

   public void deleteById(int id){
      repo.deleteById(id);
   }

   public void deleteAll(){
      repo.deleteAll();
   }

   public void bookTable(int id, String custName){
      Tables oldTable = getById(id);
      Customer customer = customerService.saveCustomer(new Customer());
      customer.setName(custName);

      oldTable.setBooked(true);
      oldTable.setCustomerId(customer.getId());
      
      saveTable(oldTable);      
   }

   public void payTable(int id, String review){
      Tables oldTable = getById(id);
      Customer customer = customerService.getById(oldTable.getCustomerId());

      oldTable.setBooked(false);
      oldTable.setCustomerId(0);

      customer.setBillPaid(true);
      customer.setReview(review);
      customerService.saveCustomer(customer);
      saveTable(oldTable); 
   }
   

}
