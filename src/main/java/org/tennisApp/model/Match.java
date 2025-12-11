package org.tennisApp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Match {

    private UUID id;
    private Long firstPlayerId;
    private Long secondPlayerId;
    private int score;

    public Match() {
        this.id = UUID.randomUUID();
    }

    public Match(Long firstPlayerId, Long secondPlayerId, int score) {
        this.id = UUID.randomUUID();
        this.firstPlayerId = firstPlayerId;
        this.secondPlayerId = secondPlayerId;
        this.score = score;
    }

    public Long getFirstPlayerId() {
        return firstPlayerId;
    }

    public void setFirstPlayerId(Long firstPlayerId) {
        this.firstPlayerId = firstPlayerId;
    }

    public Long getSecondPlayerId() {
        return secondPlayerId;
    }

    public void setSecondPlayerId(Long secondPlayerId) {
        this.secondPlayerId = secondPlayerId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
