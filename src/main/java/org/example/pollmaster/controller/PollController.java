package org.example.pollmaster.controller;

import org.example.pollmaster.domain.Poll;
import org.example.pollmaster.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Poll newPoll(@RequestBody Poll newPoll) {
        return pollService.savePoll(newPoll);
    }

    @PutMapping("/{id}")
    public Poll replacePoll(@RequestBody Poll newPoll, @PathVariable Integer id) {

        return pollService.changePoll(newPoll, id);
    }

    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable Integer id) {
        pollService.deletePoll(id);
    }








}
