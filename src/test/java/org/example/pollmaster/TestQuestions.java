package org.example.pollmaster;

import org.example.pollmaster.controller.QuestionController;
import org.example.pollmaster.domain.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestQuestions {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    QuestionController questionController;

    @Test
    public void getAllQuestions() throws Exception {
        this.mockMvc.perform(get("/questions"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getFirstPollQuestions() throws Exception {
        this.mockMvc.perform(get("/poll/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void sendFirstPollQuestion() throws Exception {
        Question question = new Question();
        question.setContent("new test question"+ UUID.randomUUID());
        this.mockMvc.perform(post("/poll/1")
                .content(TestPolls.asJsonString(question))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void changeFirstQuestion() throws Exception {
        Question question = new Question();
        question.setContent("new test question"+UUID.randomUUID());
        this.mockMvc.perform(put("/questions/1")
                .content(TestPolls.asJsonString(question))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteQuestion() throws  Exception{
        //id удаляемого вопроса задаётся вручную
        this.mockMvc.perform(delete("/questions/77"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
