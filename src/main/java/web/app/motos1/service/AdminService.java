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
import web.app.motos1.entities.Admin;
import web.app.motos1.entities.AdminCrud;



/**
 *
 * @author HP
 */
@Service
public class AdminService {
    @Autowired
    private AdminCrud adminCrudRepository;
    
    public List<Admin> getAll() {return (List<Admin>) adminCrudRepository.findAll();};
    
    public Optional<Admin> getAdmin(int id) {return adminCrudRepository.findById(id);};
    
    public Admin save(Admin admin) {
        if(admin.getId()==null){
            return adminCrudRepository.save(admin);
            
        }else{
            Optional<Admin> co = adminCrudRepository.findById(admin.getId());
            if(co.isEmpty()){
                return adminCrudRepository.save(admin);
            }else{
                return admin;
            }
    }
  }   
}
