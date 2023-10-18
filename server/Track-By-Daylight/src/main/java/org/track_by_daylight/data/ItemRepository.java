package org.track_by_daylight.data;

import org.track_by_daylight.models.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> findAll();
}
