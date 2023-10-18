package org.track_by_daylight.models;

import java.util.Objects;

public class SurvivorOffering {

    public int survivorOfferingId;

    public int survivorId;

    public Offering offering;

    public SurvivorOffering() {
    }

    public SurvivorOffering(int survivorOfferingId, int survivorId, Offering offering) {
        this.survivorOfferingId = survivorOfferingId;
        this.survivorId = survivorId;
        this.offering = offering;
    }

    public int getSurvivorOfferingId() {
        return survivorOfferingId;
    }

    public void setSurvivorOfferingId(int survivorOfferingId) {
        this.survivorOfferingId = survivorOfferingId;
    }

    public int getSurvivorId() {
        return survivorId;
    }

    public void setSurvivorId(int survivorId) {
        this.survivorId = survivorId;
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
        SurvivorOffering that = (SurvivorOffering) o;
        return survivorOfferingId == that.survivorOfferingId && survivorId == that.survivorId && Objects.equals(offering, that.offering);
    }

    @Override
    public int hashCode() {
        return Objects.hash(survivorOfferingId, survivorId, offering);
    }
}
