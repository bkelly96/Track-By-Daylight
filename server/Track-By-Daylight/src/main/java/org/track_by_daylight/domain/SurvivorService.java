package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.SurvivorRepository;
import org.track_by_daylight.models.Survivor;

import java.util.List;

@Service
public class SurvivorService {

    private final SurvivorRepository repository;

    public SurvivorService(SurvivorRepository repository) {
        this.repository = repository;
    }

    public List<Survivor> findAll() {return repository.findAll(); }

    public List<Survivor> findSurvivorByTrialId(int trialId){
        return repository.findSurvivorByTrialId(trialId);
    }

}
