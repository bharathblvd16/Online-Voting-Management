package com.voting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candidateId;
    private String name;
    private String email;
    private String password;
    private String partyName;
    private int age;
    private String manifesto;
    private int voteCount = 0;
    private String status = "PENDING";
    private int electionId;

    public Candidate() 
    {
    	
    }

    public int getCandidateId() 
    {
    	return candidateId; 
    	
    }
    public void setCandidateId(int candidateId) 
    {
    	this.candidateId = candidateId;
    	
    }

    public String getName() 
    {
    	return name;
    	
    }
    public void setName(String name) 
    {
    	this.name = name;
    	
    }

    public String getEmail() { 
    	return email;
    	
    }
    public void setEmail(String email) 
    {
    	this.email = email;
    	
    }

    public String getPassword() 
    {
    	return password;
    }
    public void setPassword(String password)
    {
    	this.password = password;
    }

    public String getPartyName()
    {
    	return partyName;
    }
    public void setPartyName(String partyName) 
    {
    	this.partyName = partyName;
    	
    }

    public int getAge() 
    {
    	return age; 
    	
    }
    public void setAge(int age) 
    {
    	this.age = age;
    	
    }

    public String getManifesto() 
    {
    	return manifesto;
    	
    }
    public void setManifesto(String manifesto) 
    {
    	this.manifesto = manifesto;
    	
    }

    public int getVoteCount() 
    {
    	return voteCount;
    	
    }
    public void setVoteCount(int voteCount) 
    {
    	this.voteCount = voteCount;
    	
    }

    public String getStatus() 
    {
    	return status;
    	
    }
    public void setStatus(String status) 
    {
    	this.status = status;
    	
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
