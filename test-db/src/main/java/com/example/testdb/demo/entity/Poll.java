package com.example.testdb.demo.entity;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    public String title;
    public String description;
    public String admin_entry; //private
    public String vote_entry; //public

    public Poll() {}

    public Poll(String title, String description, String admin_entry, String vote_entry, List<Answer> answers) {
        this.title = title;
        this.description = description;
        this.admin_entry = admin_entry;
        this.vote_entry = vote_entry;
        this.answers = answers;
    }

    /*
    public Poll(int id, String title, String description, List<Answer> answers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.answers = answers;
    }

     */

    public String getAdmin_entry() {
        return admin_entry;
    }

    public void setAdmin_entry(String admin_entry) {
        this.admin_entry = admin_entry;
    }

    public String getVote_entry() {
        return vote_entry;
    }

    public void setVote_entry(String vote_entry) {
        this.vote_entry = vote_entry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @OneToMany(targetEntity = Answer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ans_fk", referencedColumnName = "id")

    public List<Answer> answers;

    
}
