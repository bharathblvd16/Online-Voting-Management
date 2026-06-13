package com.voting.repository;

import com.voting.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    Candidate findByEmail(String email);
    List<Candidate> findByElectionIdOrderByVoteCountDesc(int electionId);
}
