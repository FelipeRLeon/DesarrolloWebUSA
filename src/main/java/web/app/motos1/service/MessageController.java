/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.motos1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import web.app.motos1.entities.Message;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/all")
    public List<Message> getMessage(){
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id) {
        return messageService.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    /*}
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motocicleta update(@RequestBody Motocicleta motocicleta) {
        return motocicletaService.update(motocicleta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return motocicletaService.deleteMotocicleta(id);
    }*/
    
}
}