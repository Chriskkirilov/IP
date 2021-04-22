package com.example.testdb.demo.repository;

import com.example.testdb.demo.entity.Answer;
import com.example.testdb.demo.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
