package org.track_by_daylight.models;

import java.util.Objects;

public class Killer {

    public int killerId;

    public String killerName;

    public boolean isPlayer;

    public Trial trial;

    public Killer() {
    }

    public Killer(int killerId, String killerName, boolean isPlayer, Trial trial) {
        this.killerId = killerId;
        this.killerName = killerName;
        this.isPlayer = isPlayer;
        this.trial = trial;
    }

    public int getKillerId() {
        return killerId;
    }

    public void setKillerId(int killerId) {
        this.killerId = killerId;
    }

    public String getKillerName() {
        return killerName;
    }

    public void setKillerName(String killerName) {
        this.killerName = killerName;
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
        Killer killer = (Killer) o;
        return killerId == killer.killerId && isPlayer == killer.isPlayer && Objects.equals(killerName, killer.killerName) && Objects.equals(trial, killer.trial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(killerId, killerName, isPlayer, trial);
    }
}
