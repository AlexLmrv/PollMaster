package org.example.pollmaster.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private Integer pollnumber;

    @NotEmpty
    private String content;

    @NotEmpty
    private Integer questionnumber;

    public Question() {
    }

    public Question(Integer pollnumber, String content, Integer questionnumber) {
        this.pollnumber = pollnumber;
        this.content = content;
        this.questionnumber = questionnumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPollnumber() {
        return pollnumber;
    }

    public void setPollnumber(Integer pollnumber) {
        this.pollnumber = pollnumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getQuestionnumber() {
        return questionnumber;
    }

    public void setQuestionnumber(Integer questionnumber) {
        this.questionnumber = questionnumber;
    }
}
