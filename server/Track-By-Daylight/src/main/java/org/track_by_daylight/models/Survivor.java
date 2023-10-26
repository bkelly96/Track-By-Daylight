package org.track_by_daylight.models;

import java.util.Objects;

public class Survivor {

    public int survivorId;

    public String survivorName;

    public boolean isPlayer;

    public Trial trial;

    public Survivor() {
    }

    public Survivor(int survivorId, String survivorName, boolean isPlayer, Trial trial) {
        this.survivorId = survivorId;
        this.survivorName = survivorName;
        this.isPlayer = isPlayer;
        this.trial = trial;
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

    public Trial getTrial() {
        return trial;
    }

    public void setTrial(Trial trial) {
        this.trial = trial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survivor survivor = (Survivor) o;
        return survivorId == survivor.survivorId && isPlayer == survivor.isPlayer && Objects.equals(survivorName, survivor.survivorName) && Objects.equals(trial, survivor.trial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(survivorId, survivorName, isPlayer, trial);
    }
}
