package org.example.pollmaster.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name = "polls")
public class Poll implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @Column(name = "startdate")
    private LocalDateTime startdate;

    @Column(name = "finishdate")
    private LocalDateTime finishdate;

    @Column(name = "active")
    private Boolean active;

    public Poll() {
    }

    public Poll(String name){
        this.name = name;
        this.startdate = LocalDateTime.now();
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

    public LocalDateTime getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDateTime startdate) {
        this.startdate = startdate;
    }

    public LocalDateTime getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(LocalDateTime finishdate) {
        this.finishdate = finishdate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
