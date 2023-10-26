package org.track_by_daylight.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.track_by_daylight.domain.KillerService;
import org.track_by_daylight.domain.SurvivorService;
import org.track_by_daylight.models.Killer;
import org.track_by_daylight.models.Survivor;
import org.track_by_daylight.models.Trial;

import java.util.List;

@RestController
@RequestMapping("/api/survivor")
public class SurvivorController {

    private final SurvivorService service;


    public SurvivorController(SurvivorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Survivor> findAll() {
        return service.findAll();
    }

    @GetMapping("/{trialId}")
    public List<Survivor> findSurvivorByTrialId(@PathVariable int trialId) {

        return service.findSurvivorByTrialId(trialId);
    }
}
