package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.SurvivorOfferingRepository;
import org.track_by_daylight.data.SurvivorPerkRepository;
import org.track_by_daylight.models.SurvivorOffering;
import org.track_by_daylight.models.SurvivorPerk;

import java.util.List;

@Service
public class SurvivorOfferingService {


    private final SurvivorOfferingRepository repository;

    public SurvivorOfferingService(SurvivorOfferingRepository repository) {
        this.repository = repository;
    }

    public List<SurvivorOffering> findAll() {return repository.findAll(); }
}
