package org.example.pollmaster.service;

import org.example.pollmaster.domain.Question;
import org.example.pollmaster.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public List<Question> getQuestions(Integer pollnumber) {
        return questionRepo.findByPollnumberOrderByQuestionnumber(pollnumber);//возвращает вопросы конкретного опроса
    }

    public List<Question> getAllQuestions(){
        return questionRepo.findAll();
    }

    public Question saveQuestion(Question newQuestion, Integer pollnumber) {
        newQuestion.setQuestionnumber(questionRepo.findByPollnumberOrderByQuestionnumber(pollnumber).size());
        newQuestion.setPollnumber(pollnumber);
        return questionRepo.save(newQuestion);
    }

    public Question changeQuestion(Question newQuestion, Integer id) {
        return
                questionRepo.findById(id).map(
                        question -> {
                            question.setContent(newQuestion.getContent());
                            return questionRepo.save(question);
                        })
                        .get();
                // заменяем поле content; позиция, принадлежность и id остаются прежними

    }


    public void deleteQuestion(Integer id) {
        // сначала запрашиваем объект, чтобы не вызывать его несколько раз из БД
        Question question = questionRepo.findById(id).get();
        //заранее сохраняем параметры его позиции
        Integer pollnumber = question.getPollnumber();
        Integer questionnumber = question.getQuestionnumber();
        // теперь удаляем сам объект
        questionRepo.delete(question);
        // теперь элементы со старшей позицией необходимо сдвинуть влево
        questionRepo.findByPollnumberOrderByQuestionnumber(pollnumber).forEach(elem -> {
            if (elem.getQuestionnumber() > questionnumber){
                elem.setQuestionnumber(elem.getQuestionnumber() - 1);
            }
            questionRepo.save(elem);
        });

    }
}
