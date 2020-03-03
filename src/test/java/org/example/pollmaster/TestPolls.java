package org.example.pollmaster;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.pollmaster.controller.PollController;
import org.example.pollmaster.controller.QuestionController;
import org.example.pollmaster.domain.Poll;
import org.example.pollmaster.domain.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestPolls {
    @Autowired
    PollController pollController;
    @Autowired
    QuestionController questionController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPolls() throws Exception{
        this.mockMvc.perform(
                get("/polls"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void sendPolls() throws Exception{
        Poll poll = new Poll();
        poll.setFinishdate(LocalDateTime.now().plusMonths(2L));
        poll.setActive(true);
        poll.setName("testpol"+UUID.randomUUID());
        this.mockMvc.perform(post("/polls")
                .content(asJsonString(poll))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void updateFirstPoll() throws Exception{
        Poll poll = new Poll();
        poll.setStartdate(LocalDateTime.now());
        poll.setFinishdate(LocalDateTime.now().plusMonths(2L));
        poll.setActive(true);
        poll.setName("firstpoll000");
        this.mockMvc.perform(put("/polls/1")
                .content(asJsonString(poll))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deletePolls() throws Exception{
        //id удаляемого опроса задаётся вручную
        this.mockMvc.perform(delete("/polls/6"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
