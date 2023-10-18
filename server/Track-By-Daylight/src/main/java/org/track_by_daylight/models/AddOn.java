package org.track_by_daylight.models;

import java.util.Objects;

public class AddOn {

    public int addOnId;
    public String addOnName;

    public AddOn() {
    }

    public AddOn(int addOnId, String addOnName) {
        this.addOnId = addOnId;
        this.addOnName = addOnName;
    }

    public int getAddOnId() {
        return addOnId;
    }

    public void setAddOnId(int addOnId) {
        this.addOnId = addOnId;
    }

    public String getAddOnName() {
        return addOnName;
    }

    public void setAddOnName(String addOnName) {
        this.addOnName = addOnName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddOn addOn = (AddOn) o;
        return addOnId == addOn.addOnId && Objects.equals(addOnName, addOn.addOnName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addOnId, addOnName);
    }
}
