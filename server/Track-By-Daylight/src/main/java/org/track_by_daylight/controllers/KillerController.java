package org.track_by_daylight.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.track_by_daylight.domain.KillerService;
import org.track_by_daylight.models.Killer;
import org.track_by_daylight.models.Trial;

import java.util.List;

@RestController
@RequestMapping("/api/killer")
public class KillerController {

    private final KillerService service;


    public KillerController(KillerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Killer> findAll() {
        return service.findAll();
    }

    @GetMapping("/{trialId}")
    public List<Killer> findKillerByTrialId(@PathVariable int trialId) {

        return service.findKillerByTrialId(trialId);
    }
}
