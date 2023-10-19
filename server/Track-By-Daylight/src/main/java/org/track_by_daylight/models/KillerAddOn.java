package org.track_by_daylight.models;

import java.util.Objects;

public class KillerAddOn {

    public int killerAddOnId;

    public int killerId;

    public AddOn addOn;

    public KillerAddOn() {
    }

    public KillerAddOn(int killerAddOnId, int killerId, AddOn addOn) {
        this.killerAddOnId = killerAddOnId;
        this.killerId = killerId;
        this.addOn = addOn;
    }

    public int getKillerAddOnId() {
        return killerAddOnId;
    }

    public void setKillerAddOnId(int killerAddOnId) {
        this.killerAddOnId = killerAddOnId;
    }

    public int getKillerId() {
        return killerId;
    }

    public void setKillerId(int killerId) {
        this.killerId = killerId;
    }

    public AddOn getAddOn() {
        return addOn;
    }

    public void setAddOn(AddOn addOn) {
        this.addOn = addOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KillerAddOn that = (KillerAddOn) o;
        return killerAddOnId == that.killerAddOnId && killerId == that.killerId && Objects.equals(addOn, that.addOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(killerAddOnId, killerId, addOn);
    }
}
