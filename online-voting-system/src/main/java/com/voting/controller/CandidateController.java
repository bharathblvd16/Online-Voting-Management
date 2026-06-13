package com.voting.controller;

import com.voting.entity.Candidate;
import com.voting.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/candidates/register")
    public String register(@RequestBody Candidate candidate) {
        return candidateService.registerCandidate(candidate);
    }

    @PostMapping("/candidates/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {
        return candidateService.loginCandidate(email, password);
    }

    @PutMapping("/candidates/update/{id}")
    public String update(@PathVariable int id,
                         @RequestBody Candidate candidate) {
        return candidateService.updateCandidate(id, candidate);
    }

    @PostMapping("/candidates/enroll/{candidateId}/{electionId}")
    public String enroll(@PathVariable int candidateId,
                         @PathVariable int electionId) {
        return candidateService.enrollForElection(candidateId, electionId);
    }

    @GetMapping("/candidates/all")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @PutMapping("/candidates/approve/{id}")
    public String approve(@PathVariable int id) {
        return candidateService.approveCandidate(id);
    }

    @PutMapping("/candidates/reject/{id}")
    public String reject(@PathVariable int id) {
        return candidateService.rejectCandidate(id);
    }
}