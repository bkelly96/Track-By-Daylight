package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.KillerRepository;
import org.track_by_daylight.data.SurvivorPerkRepository;
import org.track_by_daylight.models.Killer;
import org.track_by_daylight.models.SurvivorPerk;

import java.util.List;

@Service
public class KillerService {

    private final KillerRepository repository;

    public KillerService(KillerRepository repository) {
        this.repository = repository;
    }

    public List<Killer> findAll() {return repository.findAll(); }

    public List<Killer> findKillerByTrialId(int trialId) {
        return repository.findKillerByTrialId(trialId);
    }
}
