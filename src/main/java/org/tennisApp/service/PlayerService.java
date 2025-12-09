package org.tennisApp.service;

import org.tennisApp.DAO.PlayerDAO;
import org.tennisApp.entity.PlayerEntity;

import java.util.List;

public class PlayerService {

    private final PlayerDAO playerDAO;

    public PlayerService() {
        this.playerDAO = new PlayerDAO();
    }


    public void addNewPlayer(PlayerEntity player) {
        this.playerDAO.addNew(player);
    }

    public List<PlayerEntity> getAllPlayers() {
        return this.playerDAO.findAll();
    }

}
