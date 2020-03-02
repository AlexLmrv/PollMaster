package org.example.pollmaster.repos;

import org.example.pollmaster.domain.Poll;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PollRepo extends CrudRepository<Poll, Integer> {

    List<Poll> findAll();
    List<Poll> findAllByOrderByName();
    List<Poll> findAllByOrderByStartdate();

    List<Poll> findByName(String name);
    List<Poll> findByNameOrderByStartdate(String name);

}
