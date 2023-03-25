package com.restaurant.restaurantmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.restaurantmanagement.entities.Menu;
import com.restaurant.restaurantmanagement.repository.MenuRepository;

@Service
public class MenuService {
    
    @Autowired
    private MenuRepository repo;


    
    public Menu saveMenu(Menu menu){
        return repo.save(menu);
     }
  
     public List<Menu> getAllMenu(){
        return repo.findAll();
     }
  
     public Menu getById(int id){
        return repo.findById(id).orElse(null);
     }
  
     public void deleteById(int id){
        repo.deleteById(id);
     }
  
     public void deleteAll(){
        repo.deleteAll();
     }

   //   public void deleteByName(String name){
   //       repo.deleteByName(name);
   //   }
     
}
