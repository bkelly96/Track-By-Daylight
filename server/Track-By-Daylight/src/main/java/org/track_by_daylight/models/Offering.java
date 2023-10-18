package org.track_by_daylight.models;

import java.util.Objects;

public class Offering {

    public int offeringId;
    public String offeringName;

    public Offering() {
    }

    public Offering(int offeringId, String offeringName) {
        this.offeringId = offeringId;
        this.offeringName = offeringName;
    }

    public int getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(int offeringId) {
        this.offeringId = offeringId;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public void setOfferingName(String offeringName) {
        this.offeringName = offeringName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offering offering = (Offering) o;
        return offeringId == offering.offeringId && Objects.equals(offeringName, offering.offeringName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offeringId, offeringName);
    }
}
