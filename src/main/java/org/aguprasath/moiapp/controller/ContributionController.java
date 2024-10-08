package org.aguprasath.moiapp.controller;

import org.aguprasath.moiapp.dto.ContributionDTO;
import org.aguprasath.moiapp.model.Contribution;
import org.aguprasath.moiapp.model.Event;
import org.aguprasath.moiapp.service.ContributionService;
import org.aguprasath.moiapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("event/{eventId}/contribution")
public class ContributionController {

    @Autowired
    private ContributionService contributionService;

    @Autowired
    private EventService eventService;



    @PostMapping("add")
    public ResponseEntity<ContributionDTO> addContribution(@PathVariable Long eventId ,@RequestBody Contribution contribution) {
        Optional<Event> event=eventService.getEventById(eventId);
        contribution.setEvent(event.get());
        Contribution newContribution=contributionService.addContribution(contribution);
        ContributionDTO contributionDTO=contributionService.mapToContributionDTO(newContribution);
        return new ResponseEntity<>(contributionDTO, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<List<ContributionDTO>> getEventContributions(@PathVariable Long eventId) {
        Optional<Event> event = eventService.getEventById(eventId);
        List<Contribution> contributions = event.get().getContributions();


        return new ResponseEntity<>(contributionService.contributionsToContributionDTO(contributions), HttpStatus.OK);
    }
    @PutMapping("/{contributionId}/update")
    public ResponseEntity<ContributionDTO> updateContribution(@PathVariable Long eventId, @RequestBody Contribution contribution) {
        Optional<Event> event=eventService.getEventById(eventId);
        contribution.setEvent(event.get());
       Contribution newContribution=contributionService.addContribution(contribution);
       ContributionDTO contributionDTO=contributionService.mapToContributionDTO(newContribution);
        return new ResponseEntity<>(contributionDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{contributionId}/delete")
    public ResponseEntity<String> deleteContribution( @PathVariable Long contributionId) {

        return new ResponseEntity<>(contributionService.deleteContribution(contributionId),HttpStatus.OK);
    }

    @GetMapping("searchByContributor")
    public ResponseEntity<List<ContributionDTO>> searchContributions(@PathVariable Long eventId,@RequestParam("name") String contributorName) {
        List<Contribution> contributions = contributionService.getContributionsByContributorName(eventId,contributorName);
        return new ResponseEntity<>(contributionService.contributionsToContributionDTO(contributions), HttpStatus.OK);
    }

    @GetMapping("status")
    public ResponseEntity<List<ContributionDTO>> searchUnsettledContributions(@PathVariable Long eventId,@RequestParam("status") Boolean status){
        List<Contribution> contributions=contributionService.getUnsettledContributions(eventId,status);
        return new ResponseEntity<>(contributionService.contributionsToContributionDTO(contributions), HttpStatus.OK);
    }

}
