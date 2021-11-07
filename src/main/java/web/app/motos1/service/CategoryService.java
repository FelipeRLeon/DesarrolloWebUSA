/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.motos1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.app.motos1.entities.Category;
import web.app.motos1.entities.CategoryCrud;



/**
 *
 * @author HP
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryCrud categoryCrudRepository;
    
    public List<Category> getAll() {return (List<Category>) categoryCrudRepository.findAll();};
    
    public Optional<Category> getCategory(int id) {return categoryCrudRepository.findById(id);};
    
    public Category save(Category category) {
        if(category.getId()==null){
            return categoryCrudRepository.save(category);
            
        }else{
            Optional<Category> co = categoryCrudRepository.findById(category.getId());
            if(co.isEmpty()){
                return categoryCrudRepository.save(category);
            }else{
                return category;
            }
    }
  }   
}
