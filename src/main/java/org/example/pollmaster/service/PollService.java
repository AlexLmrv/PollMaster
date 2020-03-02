package org.example.pollmaster.service;

import org.example.pollmaster.domain.Poll;
import org.example.pollmaster.repos.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PollService {

    @Autowired
    PollRepo pollRepo;

    public List<Poll> getPolls(String name, String sorted){
        List<Poll> polls = findPolls(name);
        switch (sorted){
            case "name":
                polls.sort(Comparator.comparing(Poll::getName));
                break;
            case "date":
                polls.sort(Comparator.comparing(Poll::getStartdate));
                break;
            default:
                break;
        }

        return polls;
    }

    public List<Poll> findPolls(String name) {
        if (name != null && !name.isEmpty() ) {
            return pollRepo.findByName(name);
        }
        else {

            return pollRepo.findAll();
        }
    }
}
