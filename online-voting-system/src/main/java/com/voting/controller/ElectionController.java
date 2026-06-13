package com.voting.controller;

import com.voting.entity.Election;
import com.voting.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ElectionController {

    @Autowired
    private ElectionService electionService;

    @PostMapping("/admin/login")
    public String adminLogin(@RequestParam String email,
                             @RequestParam String password) {
        return electionService.adminLogin(email, password);
    }

    @PostMapping("/elections/create")
    public String createElection(@RequestBody Election election) {
        return electionService.createElection(election);
    }

    @PutMapping("/elections/end/{id}")
    public String endElection(@PathVariable int id) {
        return electionService.endElection(id);
    }

    @GetMapping("/elections/all")
    public List<Election> getAllElections() {
        return electionService.getAllElections();
    }
}