package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.KillerAddOnRepository;
import org.track_by_daylight.data.KillerPerkRepository;
import org.track_by_daylight.models.KillerAddOn;
import org.track_by_daylight.models.KillerPerk;

import java.util.List;

@Service
public class KillerAddOnService {


    private final KillerAddOnRepository repository;

    public  KillerAddOnService( KillerAddOnRepository repository) {
        this.repository = repository;
    }

    public List<KillerAddOn> findAll() {return repository.findAll(); }
}
