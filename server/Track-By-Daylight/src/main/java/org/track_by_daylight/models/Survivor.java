package org.track_by_daylight.models;

import java.util.Objects;

public class Survivor {

    public int survivorId;

    public String survivorName;

    public boolean isPlayer;

    public int trialId;

    public Survivor() {
    }

    public Survivor(int survivorId, String survivorName, boolean isPlayer, int trialId) {
        this.survivorId = survivorId;
        this.survivorName = survivorName;
        this.isPlayer = isPlayer;
        this.trialId = trialId;
    }

    public int getSurvivorId() {
        return survivorId;
    }

    public void setSurvivorId(int survivorId) {
        this.survivorId = survivorId;
    }

    public String getSurvivorName() {
        return survivorName;
    }

    public void setSurvivorName(String survivorName) {
        this.survivorName = survivorName;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    public int getTrialId() {
        return trialId;
    }

    public void setTrialId(int trialId) {
        this.trialId = trialId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survivor survivor = (Survivor) o;
        return survivorId == survivor.survivorId && isPlayer == survivor.isPlayer && trialId == survivor.trialId && Objects.equals(survivorName, survivor.survivorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(survivorId, survivorName, isPlayer, trialId);
    }
}
