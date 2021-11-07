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
import web.app.motos1.entities.Client;
import web.app.motos1.entities.ClientCrud;



/**
 *
 * @author HP
 */
@Service
public class ClientService {
    @Autowired
    private ClientCrud clientCrudRepository;
    
    public List<Client> getAll() {return (List<Client>) clientCrudRepository.findAll();};
    
    public Optional<Client> getClient(int id) {return clientCrudRepository.findById(id);};
    
    public Client save(Client client) {
        if(client.getId()==null){
            return clientCrudRepository.save(client);
            
        }else{
            Optional<Client> co = clientCrudRepository.findById(client.getId());
            if(co.isEmpty()){
                return clientCrudRepository.save(client);
            }else{
                return client;
            }
    }
  }   
}
