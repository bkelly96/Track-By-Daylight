package org.track_by_daylight.models;

import java.util.Objects;

public class SurvivorPerk {

    public int survivorPerkId;

    public int survivorId;

    public Perk perk;

    public SurvivorPerk() {
    }

    public SurvivorPerk(int survivorPerkId, int survivorId, Perk perk) {
        this.survivorPerkId = survivorPerkId;
        this.survivorId = survivorId;
        this.perk = perk;
    }

    public int getSurvivorPerkId() {
        return survivorPerkId;
    }

    public void setSurvivorPerkId(int survivorPerkId) {
        this.survivorPerkId = survivorPerkId;
    }

    public int getSurvivorId() {
        return survivorId;
    }

    public void setSurvivorId(int survivorId) {
        this.survivorId = survivorId;
    }

    public Perk getPerk() {
        return perk;
    }

    public void setPerk(Perk perk) {
        this.perk = perk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurvivorPerk that = (SurvivorPerk) o;
        return survivorPerkId == that.survivorPerkId && survivorId == that.survivorId && Objects.equals(perk, that.perk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(survivorPerkId, survivorId, perk);
    }
}
