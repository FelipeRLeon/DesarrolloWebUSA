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
import web.app.motos1.entities.Score;
import web.app.motos1.entities.ScoreCrud;



/**
 *
 * @author HP
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreCrud scoreCrudRepository;
    
    public List<Score> getAll() {return (List<Score>) scoreCrudRepository.findAll();};
    
    public Optional<Score> getScore(int id) {return scoreCrudRepository.findById(id);};
    
    public Score save(Score score) {
        if(score.getId()==null){
            return scoreCrudRepository.save(score);
            
        }else{
            Optional<Score> co = scoreCrudRepository.findById(score.getId());
            if(co.isEmpty()){
                return scoreCrudRepository.save(score);
            }else{
                return score;
            }
    }
  }   
}
