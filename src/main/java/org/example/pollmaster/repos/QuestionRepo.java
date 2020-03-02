package org.example.pollmaster.repos;

import org.example.pollmaster.domain.Question;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface QuestionRepo extends CrudRepository<Question, Integer> {

    List<Question> findAll();
    List<Question> findByPollnumber(Integer pollnumber);
}
