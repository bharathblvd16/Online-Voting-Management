package com.voting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voters")
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voterId;
    private String name;
    private String email;
    private String password;
    private int age;
    private String address;
    private boolean hasVoted = false;

    public Voter() 
    {
    	
    }

    public int getVoterId() 
    { 
    	return voterId; 
    }
    public void setVoterId(int voterId) 
    { 
    	this.voterId = voterId; 
    }

    public String getName() 
    { 
    	return name; 
    }
    public void setName(String name)
    { 
    	this.name = name; 
    }

    public String getEmail() 
    {
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

    public int getAge() 
    {
    	return age;
    }
    public void setAge(int age) 
    {
    	this.age = age; 
    }

    public String getAddress() 
    {
    	return address;
    }
    public void setAddress(String address) 
    { 
    	this.address = address; 
    }

    public boolean isHasVoted() 
    {
    	return hasVoted;
    }
    public void setHasVoted(boolean hasVoted)
    {
    	this.hasVoted = hasVoted;
    	
    }
}