package org.example.pollmaster.controller;

import org.example.pollmaster.domain.Poll;
import org.example.pollmaster.domain.Question;
import org.example.pollmaster.service.PollService;
import org.example.pollmaster.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/polls")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/{pollnumber}")
    public List<Question> allQuestions(@PathVariable Integer pollnumber
    ){
        return questionService.getQuestions(pollnumber);
    }

    @PostMapping
    public Question newQuestion(@RequestBody Question newQuestion) {
        return questionService.saveQuestion(newQuestion);
    }

    @PutMapping("/{poll_number}/{question_number}")
    public Question replaceQuestion(
            @RequestBody Question newQuestion,
            @PathVariable("poll_number") Integer pollnumber,
            @PathVariable("question_number") Integer questionnumber
            ) {

        return questionService.changeQuestion(newQuestion, pollnumber, questionnumber);
    }

    @DeleteMapping("/{poll_number}/{question_number}")
    public void deleteQuestion( @PathVariable("poll_number") Integer pollnumber,
                                @PathVariable("question_number") Integer questionnumber) {
        questionService.deleteQuestion(pollnumber, questionnumber);
    }
}
