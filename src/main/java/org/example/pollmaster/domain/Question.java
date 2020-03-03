package org.example.pollmaster.domain;


import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @Column(name = "pollnumber")
    private Integer pollnumber;


    @Column(name = "content")
    private String content;


    @Column(name = "questionnumber")
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
