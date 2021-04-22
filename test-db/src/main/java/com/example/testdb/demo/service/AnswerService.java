package com.example.testdb.demo.service;

import com.example.testdb.demo.entity.Answer;
import com.example.testdb.demo.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> findAll(){
        return answerRepository.findAll();
    }

}