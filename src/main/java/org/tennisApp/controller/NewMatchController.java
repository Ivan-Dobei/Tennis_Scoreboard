package org.tennisApp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tennisApp.DTO.NewMatchRequest;
import org.tennisApp.DTO.NewMatchResponse;
import org.tennisApp.exception.InvalidCredentialsException;
import org.tennisApp.mapper.JsonMapper;
import org.tennisApp.service.OngoingMatchesService;
import org.tennisApp.util.ErrorResponseUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
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
        PrintWriter writer = response.getWriter();
        try {
            String requestJson = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            NewMatchRequest matchRequest = JsonMapper.fromJson(requestJson, NewMatchRequest.class);
            checkRequestParams(matchRequest);

            UUID newMatchId = this.matchesService.registerNewMatch(matchRequest);

            response.setStatus(HttpServletResponse.SC_CREATED);
            writer.write(JsonMapper.toJson(new NewMatchResponse(newMatchId)));

        } catch (InvalidCredentialsException e) {
            ErrorResponseUtil.handleError(writer, response, e.getMessage(), HttpServletResponse.SC_BAD_REQUEST);
        } catch (Exception e) {
            ErrorResponseUtil.handleError(writer, response, e.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

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
