package org.example.pollmaster.controller;

import com.datical.liquibase.ext.license.LicenseCheckingSnapshotGenerator;
import org.example.pollmaster.domain.Poll;
import org.example.pollmaster.repos.PollRepo;
import org.example.pollmaster.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    PollService pollService;

    @GetMapping
    public List<Poll> allPolls(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "date") String sorted
    ){
        return pollService.getPolls(name, sorted);
    }






}
