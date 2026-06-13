package com.voting.service;

import com.voting.entity.Candidate;
import com.voting.repository.CandidateRepository;
import com.voting.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ElectionRepository electionRepository;

    // REGISTER
    public String registerCandidate(Candidate candidate) {
        Candidate existing = candidateRepository.findByEmail(candidate.getEmail());
        if (existing != null) return "Email already registered";
        candidate.setStatus("PENDING");
        candidateRepository.save(candidate);
        return "Candidate registered successfully";
    }

    // LOGIN
    public String loginCandidate(String email, String password) {
        Candidate candidate = candidateRepository.findByEmail(email);
        if (candidate == null) return "Candidate not found";
        if (!candidate.getPassword().equals(password)) return "Wrong password";
        return "Login successful. Welcome " + candidate.getName();
    }

    // UPDATE
    public String updateCandidate(int id, Candidate updatedCandidate) {
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if (candidate == null) return "Candidate not found";
        candidate.setPartyName(updatedCandidate.getPartyName());
        candidate.setManifesto(updatedCandidate.getManifesto());
        candidate.setAge(updatedCandidate.getAge());
        candidateRepository.save(candidate);
        return "Candidate updated successfully";
    }

    // ENROLL FOR ELECTION
    public String enrollForElection(int candidateId, int electionId) {
        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        if (candidate == null) return "Candidate not found";
        boolean electionExists = electionRepository.existsById(electionId);
        if (!electionExists) return "Election not found";
        candidate.setElectionId(electionId);
        candidateRepository.save(candidate);
        return "Enrolled successfully";
    }

    // GET ALL
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    // APPROVE
    public String approveCandidate(int id) {
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if (candidate == null) return "Candidate not found";
        candidate.setStatus("APPROVED");
        candidateRepository.save(candidate);
        return "Candidate approved";
    }

    // REJECT
    public String rejectCandidate(int id) {
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if (candidate == null) return "Candidate not found";
        candidate.setStatus("REJECTED");
        candidateRepository.save(candidate);
        return "Candidate rejected";
    }
}