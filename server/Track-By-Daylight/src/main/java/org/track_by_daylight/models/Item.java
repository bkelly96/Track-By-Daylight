package org.track_by_daylight.models;

import java.util.Objects;

public class Item {

    public int itemId;
    public String itemName;

    public Item() {
    }

    public Item(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId == item.itemId && itemName == item.itemName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName);
    }
}
