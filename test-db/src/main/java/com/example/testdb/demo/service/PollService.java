package com.example.testdb.demo.service;

import com.example.testdb.demo.entity.Poll;
import com.example.testdb.demo.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<Poll> findAll(){
        return pollRepository.findAll();
    }

}