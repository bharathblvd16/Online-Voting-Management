package com.voting.repository;

import com.voting.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Integer> {
    Voter findByEmail(String email);
}
