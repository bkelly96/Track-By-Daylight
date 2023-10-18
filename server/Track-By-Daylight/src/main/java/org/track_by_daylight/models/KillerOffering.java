package org.track_by_daylight.models;

import java.util.Objects;

public class KillerOffering {

    public int killerOfferingId;

    public int killerId;

    public Offering offering;

    public KillerOffering() {
    }

    public KillerOffering(int killerOfferingId, int killerId, Offering offering) {
        this.killerOfferingId = killerOfferingId;
        this.killerId = killerId;
        this.offering = offering;
    }

    public int getKillerOfferingId() {
        return killerOfferingId;
    }

    public void setKillerOfferingId(int killerOfferingId) {
        this.killerOfferingId = killerOfferingId;
    }

    public int getKillerId() {
        return killerId;
    }

    public void setKillerId(int killerId) {
        this.killerId = killerId;
    }

    public Offering getOffering() {
        return offering;
    }

    public void setOffering(Offering offering) {
        this.offering = offering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KillerOffering that = (KillerOffering) o;
        return killerOfferingId == that.killerOfferingId && killerId == that.killerId && Objects.equals(offering, that.offering);
    }

    @Override
    public int hashCode() {
        return Objects.hash(killerOfferingId, killerId, offering);
    }
}
