package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.TrialRepository;
import org.track_by_daylight.models.Trial;

import java.util.List;

@Service
public class TrialService {

    private final TrialRepository repository;

    public TrialService(TrialRepository repository) {
        this.repository = repository;
    }

    public List<Trial> findAll() {return repository.findAll(); }

    public List<Trial> findByUserId(int userId) {

        return repository.findByUserId(userId);
    }

    public List<Trial> findByUsername(String username){
        return repository.findByUsername(username);
    }
}
