package com.voting.controller;

import com.voting.entity.Candidate;
import com.voting.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @PostMapping("/vote/cast")
    public String castVote(@RequestParam int voterId,
                           @RequestParam int candidateId,
                           @RequestParam int electionId) {
        return votingService.castVote(voterId, candidateId, electionId);
    }

    @GetMapping("/vote/results/{electionId}")
    public List<Candidate> getResults(@PathVariable int electionId) {
        return votingService.getResults(electionId);
    }
}