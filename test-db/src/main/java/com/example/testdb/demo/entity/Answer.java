package com.example.testdb.demo.entity;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int aid;
    public String question;
    public int poll_id;
    public int votes = 0;

    public Answer() {}

    public Answer(String question, int votes) {
        this.question = question;
        this.votes = votes;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}