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
import web.app.motos1.dao.MotorbikeRepository;
import web.app.motos1.entities.Motorbike;
import web.app.motos1.entities.MotorbikeCrud;

/**
 *
 * @author HP
 */
@Service

public class MotorbikeService {
    @Autowired
    private MotorbikeCrud motorbikeCrudRepository;
    
    public List<Motorbike> getAll() {return (List<Motorbike>) motorbikeCrudRepository.findAll();};
    
    public Optional<Motorbike> getMotorbike(int id) {return motorbikeCrudRepository.findById(id);};
    
    public Motorbike save(Motorbike motorbike) {
        if(motorbike.getId()==null){
            return motorbikeCrudRepository.save(motorbike);
            
        }else{
            Optional<Motorbike> co = motorbikeCrudRepository.findById(motorbike.getId());
            if(co.isEmpty()){
                return motorbikeCrudRepository.save(motorbike);
            }else{
                return motorbike;
            }
    }
  }   
}
