package org.track_by_daylight.models;

import java.util.Objects;

public class Perk {

    public int perkId;

    public String perkName;

    public Perk() {
    }

    public Perk(int perkId, String perkName) {
        this.perkId = perkId;
        this.perkName = perkName;
    }

    public int getPerkId() {
        return perkId;
    }

    public void setPerkId(int perkId) {
        this.perkId = perkId;
    }

    public String getPerkName() {
        return perkName;
    }

    public void setPerkName(String perkName) {
        this.perkName = perkName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perk perk = (Perk) o;
        return perkId == perk.perkId && Objects.equals(perkName, perk.perkName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perkId, perkName);
    }
}
