package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.SurvivorItemRepository;
import org.track_by_daylight.data.SurvivorPerkRepository;
import org.track_by_daylight.models.SurvivorItem;
import org.track_by_daylight.models.SurvivorPerk;

import java.util.List;

@Service
public class SurvivorItemService {

    private final SurvivorItemRepository repository;

    public SurvivorItemService(SurvivorItemRepository repository) {
        this.repository = repository;
    }

    public List<SurvivorItem> findAll() {return repository.findAll(); }
}
