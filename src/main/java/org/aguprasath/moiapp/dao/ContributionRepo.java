package org.aguprasath.moiapp.dao;

import org.aguprasath.moiapp.model.Contribution;
import org.aguprasath.moiapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionRepo extends JpaRepository<Contribution, Long> {


    List<Contribution> findByEventIdAndContributorName(Long eventId, String contributorName);

    List<Contribution> findByEventIdAndStatus(Long eventId, String status);
}
