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
import web.app.motos1.entities.Reservation;
import web.app.motos1.entities.ReservationCrud;



/**
 *
 * @author HP
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationCrud reservationCrudRepository;
    
    public List<Reservation> getAll() {return (List<Reservation>) reservationCrudRepository.findAll();};
    
    public Optional<Reservation> getReservation(int id) {return reservationCrudRepository.findById(id);};
    
    public Reservation save(Reservation reservation) {
        if(reservation.getId()==null){
            return reservationCrudRepository.save(reservation);
            
        }else{
            Optional<Reservation> co = reservationCrudRepository.findById(reservation.getId());
            if(co.isEmpty()){
                return reservationCrudRepository.save(reservation);
            }else{
                return reservation;
            }
    }
  }   
}
