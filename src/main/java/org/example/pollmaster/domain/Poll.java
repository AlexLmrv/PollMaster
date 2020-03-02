package org.example.pollmaster.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private Calendar startdate;

    private Calendar finishdate;

    private Boolean active;

    public Poll() {
    }

    public Poll(String name){
        this.name = name;
        this.startdate = Calendar.getInstance();
        this.active = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getStartdate() {
        return startdate;
    }

    public void setStartdate(Calendar startdate) {
        this.startdate = startdate;
    }

    public Calendar getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Calendar finishdate) {
        this.finishdate = finishdate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
