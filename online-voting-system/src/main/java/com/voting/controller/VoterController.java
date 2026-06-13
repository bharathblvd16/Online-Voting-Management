package com.voting.controller;

import com.voting.entity.Voter;
import com.voting.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/voters/register")
    public String register(@RequestBody Voter voter) {
        return voterService.registerVoter(voter);
    }

    @PostMapping("/voters/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {
        return voterService.loginVoter(email, password);
    }

    @PutMapping("/voters/update/{id}")
    public String update(@PathVariable int id,
                         @RequestBody Voter voter) {
        return voterService.updateVoter(id, voter);
    }

    @GetMapping("/voters/all")
    public List<Voter> getAllVoters() {
        return voterService.getAllVoters();
    }
}