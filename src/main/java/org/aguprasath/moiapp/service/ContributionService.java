package org.aguprasath.moiapp.service;

import org.aguprasath.moiapp.dao.ContributionRepo;
import org.aguprasath.moiapp.model.Contribution;
import org.aguprasath.moiapp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContributionService {

    @Autowired
    private ContributionRepo contributionRepo;



    public Contribution addContribution(Contribution contribution) {
        return contributionRepo.save(contribution);
    }

    public List<Contribution> getAllContributions() {
        return contributionRepo.findAll();
    }



    public List<Contribution> getContributionsByEvent(Event event) {
        return contributionRepo.findByEvent(event);
    }

    public Optional<Contribution> getContributionById(Long contributionId) {
        return contributionRepo.findById(contributionId);
    }
}
