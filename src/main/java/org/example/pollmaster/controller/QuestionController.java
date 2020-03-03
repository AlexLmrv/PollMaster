package org.example.pollmaster.controller;

import org.example.pollmaster.domain.Question;
import org.example.pollmaster.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;


    //получение списка вопросов конкретного опроса
    @GetMapping("/poll/{pollnumber}")
    public List<Question> pollQuestions(@PathVariable Integer pollnumber
    ){
        return questionService.getQuestions(pollnumber);
    }

    //создание вопроса для конкретного опроса
    @PostMapping("/poll/{pollnumber}")
    public Question newQuestion(
            @RequestBody Question newQuestion,
            @PathVariable Integer pollnumber) {
        return questionService.saveQuestion(newQuestion, pollnumber);
    }

    //получение всех вопросов
    @GetMapping("/questions")
    public List<Question> allQuestions(){
        return questionService.getAllQuestions();
    }



    @PutMapping("/questions/{id}")
    public Question replaceQuestion(
            @RequestBody Question newQuestion,
            @PathVariable Integer id
            ) {

        return questionService.changeQuestion(newQuestion, id);
    }

    @DeleteMapping("/questions/{id}")
    public void deleteQuestion( @PathVariable Integer id) {
        questionService.deleteQuestion(id);
    }
}
