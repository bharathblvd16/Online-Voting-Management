package com.voting.service;

import com.voting.entity.Voter;
import com.voting.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    // REGISTER
    public String registerVoter(Voter voter) {
        Voter existing = voterRepository.findByEmail(voter.getEmail());
        if (existing != null) {
            return "Email already registered";
        }
        voterRepository.save(voter);
        return "Voter registered successfully";
    }

    // LOGIN
    public String loginVoter(String email, String password) {
        Voter voter = voterRepository.findByEmail(email);
        if (voter == null) return "Voter not found";
        if (!voter.getPassword().equals(password)) return "Wrong password";
        return "Login successful. Welcome " + voter.getName();
    }

    // UPDATE
    public String updateVoter(int id, Voter updatedVoter) {
        Voter voter = voterRepository.findById(id).orElse(null);
        if (voter == null) return "Voter not found";

        voter.setName(updatedVoter.getName());
        voter.setAge(updatedVoter.getAge());
        voter.setAddress(updatedVoter.getAddress());
        // Don't touch email, password — keep existing values
        voterRepository.save(voter);
        return "Voter updated successfully";
    }

    // GET ALL
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }
}