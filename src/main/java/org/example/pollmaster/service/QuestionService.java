package org.example.pollmaster.service;

import org.example.pollmaster.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    public List<Question> getQuestions(Integer pollnumber) {


    }

    public Question saveQuestion(Question newQuestion) {
    }

    public Question changeQuestion(Question newQuestion, Integer pollnumber, Integer questionnumber) {
    }

    public void deleteQuestion(Integer pollnumber, Integer questionnumber) {

    }
}
