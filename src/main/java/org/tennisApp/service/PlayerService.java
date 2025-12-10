package org.tennisApp.service;

import org.tennisApp.DAO.PlayerDAO;
import org.tennisApp.entity.PlayerEntity;

import java.util.List;
import java.util.Optional;

public class PlayerService {

    private final PlayerDAO playerDAO;

    public PlayerService() {
        this.playerDAO = new PlayerDAO();
    }


    public Long addNewPlayer(PlayerEntity player) {
        Optional<PlayerEntity> playerEntityOpt = this.playerDAO.findByName(player.getName());
        if (playerEntityOpt.isPresent()) {
            return playerEntityOpt.get().getId();
        }

        return  this.playerDAO.addNew(player);
    }

    public List<PlayerEntity> getAllPlayers() {
        return this.playerDAO.findAll();
    }



}
