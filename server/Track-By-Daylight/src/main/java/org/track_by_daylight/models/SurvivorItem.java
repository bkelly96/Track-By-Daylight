package org.track_by_daylight.models;

import java.util.Objects;

public class SurvivorItem {

    public int survivorItemId;

    public int survivorId;

    public Item item;

    public SurvivorItem() {
    }

    public SurvivorItem(int survivorItemId, int survivorId, Item item) {
        this.survivorItemId = survivorItemId;
        this.survivorId = survivorId;
        this.item = item;
    }

    public int getSurvivorItemId() {
        return survivorItemId;
    }

    public void setSurvivorItemId(int survivorItemId) {
        this.survivorItemId = survivorItemId;
    }

    public int getSurvivorId() {
        return survivorId;
    }

    public void setSurvivorId(int survivorId) {
        this.survivorId = survivorId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurvivorItem that = (SurvivorItem) o;
        return survivorItemId == that.survivorItemId && survivorId == that.survivorId && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(survivorItemId, survivorId, item);
    }
}
