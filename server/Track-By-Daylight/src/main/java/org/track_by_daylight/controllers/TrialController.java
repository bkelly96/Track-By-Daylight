package org.track_by_daylight.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{userId}")
    public List<Trial> findByUserId(@PathVariable int userId) {

        return service.findByUserId(userId);
    }

    @GetMapping("/account/{username}")
    public List<Trial> findByUsername(@PathVariable String username) {

        return service.findByUsername(username);
    }
}