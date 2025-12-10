package org.tennisApp.DTO;

public class NewMatchRequest {

    private String firstPlayer;
    private String secondPlayer;

    public NewMatchRequest() {}

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(String firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public String getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(String secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
}
