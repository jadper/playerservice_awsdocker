package com.jadper.player.service;

import com.jadper.player.model.Player;
import com.jadper.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    
    public List<Player> listPlayers() {
        return playerRepository.findAll();
    }

    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    public Player getPlayer(Integer id) {
        return playerRepository.findById(id).get();
    }

    public boolean deletePlayer(Integer id) {
        try { 
            playerRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }   
    }

    public void updatePlayer(Map<String, Object> updates, Integer id){
        //pick out attributes for save
        Player p = playerRepository.findById(id).get();	

        if (updates.containsKey("name")){
            p.setName(updates.get("name").toString() );    
        }
        if (updates.containsKey("jersey")){
            p.setJersey(Integer.parseInt(updates.get("jersey").toString()));
        }
        if (updates.containsKey("teamId")){
            p.setTeamId(Integer.parseInt(updates.get("teamId").toString()));
        }

        playerRepository.save(p);
    }

}
