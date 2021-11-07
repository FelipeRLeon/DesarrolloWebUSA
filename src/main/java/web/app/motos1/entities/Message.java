/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.motos1.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table (name="message")
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
        private String messageText;
        private Integer motorbike;
        private Integer client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Integer motorbike) {
        this.motorbike = motorbike;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    
}
