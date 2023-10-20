package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.SurvivorAddOnRepository;
import org.track_by_daylight.data.SurvivorPerkRepository;
import org.track_by_daylight.models.SurvivorAddOn;
import org.track_by_daylight.models.SurvivorPerk;

import java.util.List;

@Service
public class SurvivorAddOnService {


    private final SurvivorAddOnRepository repository;

    public SurvivorAddOnService(SurvivorAddOnRepository repository) {
        this.repository = repository;
    }

    public List<SurvivorAddOn> findAll() {return repository.findAll(); }
}


