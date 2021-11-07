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
import web.app.motos1.entities.Message;
import web.app.motos1.entities.MessageCrud;



/**
 *
 * @author HP
 */
@Service
public class MessageService {
    @Autowired
    private MessageCrud messageCrudRepository;
    
    public List<Message> getAll() {return (List<Message>) messageCrudRepository.findAll();};
    
    public Optional<Message> getMessage(int id) {return messageCrudRepository.findById(id);};
    
    public Message save(Message message) {
        if(message.getId()==null){
            return messageCrudRepository.save(message);
            
        }else{
            Optional<Message> co = messageCrudRepository.findById(message.getId());
            if(co.isEmpty()){
                return messageCrudRepository.save(message);
            }else{
                return message;
            }
    }
  }   
}
