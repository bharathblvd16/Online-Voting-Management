# Online Voting Management System

A backend REST API built using Java and Spring Boot.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Postman

## Modules
- Voter Module
- Candidate Module
- Election Module
- Voting Module

## Key Features
- 3 role system: Voter, Candidate, Admin
- One-time voting logic
- Candidate approval workflow
- Election lifecycle: ACTIVE → ENDED
- Results with winner on top

## API Endpoints

### Voter
POST   /voters/register
POST   /voters/login
PUT    /voters/update/{id}
GET    /voters/all

### Candidate
POST   /candidates/register
POST   /candidates/login
PUT    /candidates/update/{id}
POST   /candidates/enroll/{candidateId}/{electionId}
GET    /candidates/all
PUT    /candidates/approve/{id}
PUT    /candidates/reject/{id}

### Election
POST   /admin/login
POST   /elections/create
PUT    /elections/end/{id}
GET    /elections/all

### Voting
POST   /vote/cast
GET    /vote/results/{electionId}

## How to Run
1. Create MySQL database: voting_db
2. Update application.properties with your password
3. Run as Spring Boot App
4. Test APIs using Postman
