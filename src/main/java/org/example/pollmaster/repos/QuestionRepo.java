package org.example.pollmaster.repos;

import org.example.pollmaster.domain.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepo extends CrudRepository<Question, Integer> {

    List<Question> findAll();
    List<Question> findByPollnumberOrderByQuestionnumber(Integer pollnumber);
}
