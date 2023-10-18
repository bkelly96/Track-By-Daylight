package org.track_by_daylight.models;

import java.util.Objects;

public class KillerPerk {

    public int killerPerkId;

    public int killerId;

    public Perk perk;

    public KillerPerk() {
    }

    public KillerPerk(int killerPerkId, int killerId, Perk perk) {
        this.killerPerkId = killerPerkId;
        this.killerId = killerId;
        this.perk = perk;
    }

    public int getKillerPerkId() {
        return killerPerkId;
    }

    public void setKillerPerkId(int killerPerkId) {
        this.killerPerkId = killerPerkId;
    }

    public int getKillerId() {
        return killerId;
    }

    public void setKillerId(int killerId) {
        this.killerId = killerId;
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
        KillerPerk that = (KillerPerk) o;
        return killerPerkId == that.killerPerkId && killerId == that.killerId && Objects.equals(perk, that.perk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(killerPerkId, killerId, perk);
    }
}
