package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.KillerPerkRepository;
import org.track_by_daylight.models.KillerPerk;


import java.util.List;

@Service
public class KillerPerkService {


    private final KillerPerkRepository repository;

    public KillerPerkService(KillerPerkRepository repository) {
        this.repository = repository;
    }

    public List<KillerPerk> findAll() {return repository.findAll(); }

    public List<KillerPerk> findPerkByKillerId(int killerId) {
        return repository.findPerkByKillerId(killerId);
    }
}
