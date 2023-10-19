package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.ItemRepository;
import org.track_by_daylight.data.OfferingRepository;
import org.track_by_daylight.models.Item;
import org.track_by_daylight.models.Offering;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> findAll(){ return repository.findAll(); }
}
