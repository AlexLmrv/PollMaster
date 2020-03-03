package org.example.pollmaster.service;

import org.example.pollmaster.domain.Poll;
import org.example.pollmaster.repos.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Poll savePoll(Poll newPoll) {
        newPoll.setStartdate(LocalDateTime.now());
        newPoll.setActive(true);
        return pollRepo.save(newPoll);
    }

    public void deletePoll(Integer id) {
        pollRepo.deleteById(id);
    }

    public Poll changePoll(Poll newPoll, Integer id) {
        return pollRepo.findById(id)
                .map(poll -> {
                    poll.setName(newPoll.getName());
                    poll.setStartdate(LocalDateTime.now());
                    poll.setFinishdate(newPoll.getFinishdate());
                    poll.setActive(newPoll.getActive());
                    return pollRepo.save(newPoll);
                })
                .orElseGet(() -> {
                    newPoll.setId(id);
                    return pollRepo.save(newPoll);
                });
    }
}
