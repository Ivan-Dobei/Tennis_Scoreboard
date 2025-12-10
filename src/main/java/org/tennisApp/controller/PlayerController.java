package org.tennisApp.controller;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tennisApp.entity.PlayerEntity;
import org.tennisApp.service.PlayerService;

import java.io.IOException;
import java.util.List;

@WebServlet("/players")
public class PlayerController extends HttpServlet {

    private PlayerService playerService;

    @Override
    public void init() {
        playerService = new PlayerService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<PlayerEntity> players = this.playerService.getAllPlayers();

        response.getWriter().write(new Gson().toJson(players));
    }
}
