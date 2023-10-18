package org.track_by_daylight.models;

import java.util.Objects;

public class SurvivorAddOn {

    public int survivorAddOnId;

    public int survivorId;

    public AddOn addOn;

    public SurvivorAddOn() {
    }

    public SurvivorAddOn(int survivorAddOnId, int survivorId, AddOn addOn) {
        this.survivorAddOnId = survivorAddOnId;
        this.survivorId = survivorId;
        this.addOn = addOn;
    }

    public int getSurvivorAddOnId() {
        return survivorAddOnId;
    }

    public void setSurvivorAddOnId(int survivorAddOnId) {
        this.survivorAddOnId = survivorAddOnId;
    }

    public int getSurvivorId() {
        return survivorId;
    }

    public void setSurvivorId(int survivorId) {
        this.survivorId = survivorId;
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
        SurvivorAddOn that = (SurvivorAddOn) o;
        return survivorAddOnId == that.survivorAddOnId && survivorId == that.survivorId && Objects.equals(addOn, that.addOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(survivorAddOnId, survivorId, addOn);
    }
}
