package com.voting.service;

import com.voting.entity.*;
import com.voting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VotingService {

    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private ElectionRepository electionRepository;
    @Autowired
    private VoteRepository voteRepository;

    // CAST VOTE — main business logic
    public String castVote(int voterId, int candidateId, int electionId) {

        // Step 1 - Find voter
        Voter voter = voterRepository.findById(voterId).orElse(null);
        if (voter == null) return "Voter not found";

        // Step 2 - Find election
        Election election = electionRepository.findById(electionId).orElse(null);
        if (election == null) return "Election not found";

        // Step 3 - Check election is ACTIVE
        if (!election.getStatus().equals("ACTIVE")) {
            return "Election is not active";
        }

        // Step 4 - Check voter hasn't voted
        if (voter.isHasVoted()) {
            return "You have already voted";
        }

        // Step 5 - Find candidate
        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        if (candidate == null) return "Candidate not found";

        // Step 6 - Check candidate is APPROVED
        if (!candidate.getStatus().equals("APPROVED")) {
            return "Candidate is not approved";
        }

        // Step 7 - Save vote
        Vote vote = new Vote();
        vote.setVoterId(voterId);
        vote.setCandidateId(candidateId);
        vote.setElectionId(electionId);
        voteRepository.save(vote);

        // Step 8 - Update counts
        candidate.setVoteCount(candidate.getVoteCount() + 1);
        candidateRepository.save(candidate);

        voter.setHasVoted(true);
        voterRepository.save(voter);

        return "Vote cast successfully!";
    }

    // GET RESULTS
    public List<Candidate> getResults(int electionId) {
        return candidateRepository
                .findByElectionIdOrderByVoteCountDesc(electionId);
    }
}