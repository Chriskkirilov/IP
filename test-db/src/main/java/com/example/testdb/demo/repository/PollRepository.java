package com.example.testdb.demo.repository;

import com.example.testdb.demo.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface PollRepository extends JpaRepository<Poll, Integer> {


    Poll findById(String vote_entry);



}
