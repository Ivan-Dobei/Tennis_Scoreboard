package org.tennisApp.service;

import org.tennisApp.DTO.NewMatchRequest;
import org.tennisApp.entity.PlayerEntity;
import org.tennisApp.model.Match;

import java.util.ArrayList;
import java.util.List;

public class OngoingMatchesService {
    private final List<Match> matches;
    private final PlayerService playerService;

    public OngoingMatchesService() {
        this.playerService = new PlayerService();
        this.matches = new ArrayList<>();
    }

    public void registerNewMatch(NewMatchRequest request) {
        int NEW_MATCH_SCORE = 0;
        PlayerEntity firstPlayer = new PlayerEntity(request.getFirstPlayer());
        PlayerEntity secondPlayer = new PlayerEntity(request.getSecondPlayer());

        Long firstPlayerId = this.playerService.addNewPlayer(firstPlayer);
        Long secondPlayerId = this.playerService.addNewPlayer(secondPlayer);

        this.matches.add(new Match(firstPlayerId, secondPlayerId, NEW_MATCH_SCORE));
    }
}
