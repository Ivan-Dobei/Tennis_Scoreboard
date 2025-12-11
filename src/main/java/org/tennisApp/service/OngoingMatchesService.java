package org.tennisApp.service;

import org.tennisApp.DTO.NewMatchRequest;
import org.tennisApp.entity.PlayerEntity;
import org.tennisApp.model.Match;

import java.util.HashMap;
import java.util.UUID;

public class OngoingMatchesService {
    private final HashMap<UUID, Match> matches;
    private final PlayerService playerService;

    public OngoingMatchesService() {
        this.playerService = new PlayerService();
        this.matches = new HashMap<>();
    }

    public UUID registerNewMatch(NewMatchRequest request) {
        int NEW_MATCH_SCORE = 0;
        PlayerEntity firstPlayer = new PlayerEntity(request.getFirstPlayer());
        PlayerEntity secondPlayer = new PlayerEntity(request.getSecondPlayer());

        Long firstPlayerId = this.playerService.addNewPlayer(firstPlayer);
        Long secondPlayerId = this.playerService.addNewPlayer(secondPlayer);

        Match newMatch = new Match(firstPlayerId, secondPlayerId, NEW_MATCH_SCORE);

        this.matches.put(newMatch.getId(), newMatch);

        return newMatch.getId();
    }

    public Match getMatchByUUID (UUID uuid) {
        return this.matches.get(uuid);
    }
}
