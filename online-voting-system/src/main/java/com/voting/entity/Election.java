package com.voting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "elections")
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int electionId;
    private String electionName;
    private String startDate;
    private String endDate;
    private String status = "ACTIVE";

    public Election() 
    {
    	
    }

    public int getElectionId() 
    {
    	return electionId;
    	
    }
    public void setElectionId(int electionId) 
    {
    	this.electionId = electionId;
    	
    }

    public String getElectionName() 
    {
    	return electionName; 
    }
    public void setElectionName(String electionName) 
    {
    	this.electionName = electionName;
    	
    }

    public String getStartDate() 
    {
    	return startDate;
    	
    }
    public void setStartDate(String startDate) 
    {
    	this.startDate = startDate;
    	
    }

    public String getEndDate() 
    {
    	return endDate;
    	
    }
    public void setEndDate(String endDate) 
    {
    	this.endDate = endDate; 
    	
    }

    public String getStatus() 
    {
    	return status;
    }
    public void setStatus(String status) 
    {
    	this.status = status;
    	
    }
}
