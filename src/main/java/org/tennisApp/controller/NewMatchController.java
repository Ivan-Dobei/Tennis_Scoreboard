package org.tennisApp.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tennisApp.DTO.NewMatchRequest;
import org.tennisApp.exception.InvalidCredentialsException;
import org.tennisApp.model.Match;
import org.tennisApp.service.OngoingMatchesService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/new-match")
public class NewMatchController extends HttpServlet {

    private OngoingMatchesService matchesService;

    @Override
    public void init() {
        this.matchesService = new OngoingMatchesService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            request.getRequestDispatcher("/new-match.jsp").forward(request, response);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String requestJson = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            NewMatchRequest matchRequest = new Gson().fromJson(requestJson, NewMatchRequest.class);
            checkRequestParams(matchRequest);
            this.matchesService.registerNewMatch(matchRequest);

        } catch (Exception e) {
            //todo: and catch body
        }
    }

    private void checkRequestParams (NewMatchRequest request) {
        if (request.getFirstPlayer() == null ||
                request.getSecondPlayer() == null ||
                request.getFirstPlayer().equals(request.getSecondPlayer())) {
            throw new InvalidCredentialsException("Invalid player's names, please try again");
        }
    }
}
