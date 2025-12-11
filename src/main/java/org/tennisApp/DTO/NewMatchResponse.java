package org.tennisApp.DTO;

import java.util.UUID;

public class NewMatchResponse {

    private UUID uuid;

    public NewMatchResponse() {
    }

    public NewMatchResponse(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
