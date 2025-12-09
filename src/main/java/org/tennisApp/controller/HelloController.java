package org.tennisApp.controller;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tennisApp.entity.PlayerEntity;
import org.tennisApp.service.PlayerService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet("/hello")
public class HelloController extends HttpServlet {

    private PlayerService playerService;


    @Override
    public void init() {
        this.playerService = new PlayerService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        try {

            writer.write(new Gson().toJson(this.playerService.getAllPlayers()));

        } catch (Exception e) {
            writer.write(e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        try {
            String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            this.playerService.addNewPlayer(new Gson().fromJson(json, PlayerEntity.class));

        } catch (Exception e) {
            writer.write(e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
