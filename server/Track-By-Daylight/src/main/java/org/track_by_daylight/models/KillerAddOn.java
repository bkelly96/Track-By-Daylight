package org.track_by_daylight.models;

import java.util.Objects;

public class KillerAddOn {

    public int killerAddOn;

    public int killerId;

    public AddOn addOn;

    public KillerAddOn() {
    }

    public KillerAddOn(int killerAddOn, int killerId, AddOn addOn) {
        this.killerAddOn = killerAddOn;
        this.killerId = killerId;
        this.addOn = addOn;
    }

    public int getKillerAddOn() {
        return killerAddOn;
    }

    public void setKillerAddOn(int killerAddOn) {
        this.killerAddOn = killerAddOn;
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
        return killerAddOn == that.killerAddOn && killerId == that.killerId && Objects.equals(addOn, that.addOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(killerAddOn, killerId, addOn);
    }
}
