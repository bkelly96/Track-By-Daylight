package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.KillerPerkRepository;
import org.track_by_daylight.data.SurvivorPerkRepository;
import org.track_by_daylight.models.KillerPerk;
import org.track_by_daylight.models.SurvivorPerk;

import java.util.List;

@Service
public class SurvivorPerkService {


    private final SurvivorPerkRepository repository;

    public SurvivorPerkService(SurvivorPerkRepository repository) {
        this.repository = repository;
    }

    public List<SurvivorPerk> findAll() {return repository.findAll(); }

    public List<SurvivorPerk> findPerkBySurvivorId(int survivorId){
        return repository.findPerkBySurvivorId(survivorId);
    }
}
