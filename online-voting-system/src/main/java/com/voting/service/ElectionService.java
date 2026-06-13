package com.voting.service;

import com.voting.entity.Election;
import com.voting.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ElectionService {

    @Autowired
    private ElectionRepository electionRepository;

    private final String ADMIN_EMAIL = "admin@voting.com";
    private final String ADMIN_PASSWORD = "admin123";

    // ADMIN LOGIN
    public String adminLogin(String email, String password) {
        if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
            return "Admin login successful";
        }
        return "Invalid credentials";
    }

    // CREATE ELECTION
    public String createElection(Election election) {
        election.setStatus("ACTIVE");
        electionRepository.save(election);
        return "Election created successfully";
    }

    // END ELECTION
    public String endElection(int id) {
        Election election = electionRepository.findById(id).orElse(null);
        if (election == null) return "Election not found";
        election.setStatus("ENDED");
        electionRepository.save(election);
        return "Election ended successfully";
    }

    // GET ALL
    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }
}