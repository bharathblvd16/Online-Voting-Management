package com.voting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voteId;
    private int voterId;
    private int candidateId;
    private int electionId;

    public Vote() 
    {
    	
    }

    public int getVoteId()
    {
    	return voteId;
    }
    public void setVoteId(int voteId) 
    {
    	this.voteId = voteId;
    }

    public int getVoterId() 
    {
    	return voterId;
    }
    public void setVoterId(int voterId)
    {
    	this.voterId = voterId;
    }

    public int getCandidateId() 
    {
    	return candidateId;
    }
    public void setCandidateId(int candidateId) 
    {
    	this.candidateId = candidateId;
    }

    public int getElectionId() 
    {
    	return electionId;
    }
    public void setElectionId(int electionId) 
    {
    	this.electionId = electionId;
    }
}
