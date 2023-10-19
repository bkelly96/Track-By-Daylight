package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.OfferingRepository;
import org.track_by_daylight.data.PerkRepository;
import org.track_by_daylight.models.Offering;
import org.track_by_daylight.models.Perk;

import java.util.List;

@Service
public class PerkService {

    private final PerkRepository repository;

    public PerkService(PerkRepository repository) {
        this.repository = repository;
    }

    public List<Perk> findAll(){ return repository.findAll(); }
}
