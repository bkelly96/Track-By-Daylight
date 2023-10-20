package org.track_by_daylight.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.track_by_daylight.domain.AddOnService;
import org.track_by_daylight.domain.TrialService;
import org.track_by_daylight.models.AddOn;
import org.track_by_daylight.models.Trial;

import java.util.List;

@RestController
@RequestMapping("/api/trials")
public class TrialController {

    private final TrialService service;

    public TrialController(TrialService service) {
        this.service = service;
    }

    @GetMapping
    public List<Trial> findAll() {
        return service.findAll();
    }

//    @GetMapping
//    public ResponseEntity<Trial> findById(@PathVariable int trialId) {
//        List<Trial> trial = service.findById(trialId);
//        if (trial == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return ResponseEntity.ok(List<trial>);
//    }
}