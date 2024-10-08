package org.aguprasath.moiapp.service;

import org.aguprasath.moiapp.dao.ContributionRepo;
import org.aguprasath.moiapp.dto.ContributionDTO;
import org.aguprasath.moiapp.model.Contribution;
import org.aguprasath.moiapp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContributionService {

    @Autowired
    private ContributionRepo contributionRepo;



    public Contribution addContribution(Contribution contribution) {
        return contributionRepo.save(contribution);
    }


    public String deleteContribution(Long contributionId) {
        Optional<Contribution> contribution = contributionRepo.findById(contributionId);
        if (contribution.isPresent()) {
            contributionRepo.delete(contribution.get());
            return "Contribution deleted";
        }
            return "Contribution Not Found";

    }
    public ContributionDTO mapToContributionDTO(Contribution contribution) {
        return new ContributionDTO(
                contribution.getId(),
                contribution.getContributorName(),
                contribution.getAmount(),
                contribution.getRepaidAmount(),
                contribution.getStatus(),
                contribution.getRepaidDescription(),
                contribution.getEvent().getId()
        );
    }

    public List<Contribution> getContributionsByContributorName(Long eventId, String contributorName) {
    return contributionRepo.findByEventIdAndContributorName(eventId,contributorName);
    }
    public List<ContributionDTO> contributionsToContributionDTO(List<Contribution> contributions){

        List<ContributionDTO> contributionDTOs = new ArrayList<>();
        for (Contribution contribution : contributions) {
            ContributionDTO contributionDTO =mapToContributionDTO(contribution);
            contributionDTOs.add(contributionDTO);
        }

        return contributionDTOs;
    }

    public List<Contribution> getUnsettledContributions(Long eventId,Boolean status) {
        if(status){
            return contributionRepo.findByEventIdAndStatus(eventId,"PAID");
        }
        return contributionRepo.findByEventIdAndStatus(eventId,"UNPAID");
    }
}
