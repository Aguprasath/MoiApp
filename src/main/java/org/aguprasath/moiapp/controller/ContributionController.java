package org.aguprasath.moiapp.controller;

import org.aguprasath.moiapp.model.Contribution;
import org.aguprasath.moiapp.model.Event;
import org.aguprasath.moiapp.service.ContributionService;
import org.aguprasath.moiapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ContributionController {

    @Autowired
    private ContributionService contributionService;

    @Autowired
    private EventService eventService;



    @PostMapping("/addContribution")
    public Contribution addContribution(@RequestBody Contribution contribution) {
        System.out.println(contribution);
        return contributionService.addContribution(contribution);
    }
    @GetMapping("/event/{eventId}/allContributions")
    public ResponseEntity<List<Contribution>> getContributionsByEvent(@PathVariable Long eventId) {
        Event event = eventService.getEventById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        return new ResponseEntity<>(contributionService.getContributionsByEvent(event), HttpStatus.OK);
    }

    @PutMapping("/update/{contributionId}")
    public ResponseEntity<Contribution> updateRepaidAmount(@PathVariable Long contributionId, @RequestBody BigDecimal repaidAmount) {
        Contribution contribution =contributionService.getContributionById(contributionId).orElseThrow(() -> new RuntimeException("Contribution not found"));
        contribution.setRepaidAmount(repaidAmount);
        return new ResponseEntity<>(contributionService.addContribution(contribution), HttpStatus.OK);
    }

    @GetMapping("/allContributions")
    public ResponseEntity<List<Contribution>> getAllContributions() {
        return new ResponseEntity<>(contributionService.getAllContributions(), HttpStatus.OK);
    }
}
