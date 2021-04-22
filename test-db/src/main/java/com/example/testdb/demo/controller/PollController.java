package com.example.testdb.demo.controller;

import com.example.testdb.demo.entity.Answer;
import com.example.testdb.demo.entity.Poll;
import com.example.testdb.demo.repository.AnswerRepository;
import com.example.testdb.demo.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PollController {
    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private AnswerRepository answerRepository;




    @PostMapping("/addPoll")
    public AddPollResponse addPoll(@RequestBody Poll poll) {
        String uuid1 = UUID.randomUUID().toString();
        String uuid2 = UUID.randomUUID().toString();
        pollRepository.save(new Poll(
                poll.getTitle(),
                poll.getDescription(),
                uuid1,
                uuid2,
                poll.getAnswers()
        ));
        System.out.println(uuid1 + uuid2);
        return new AddPollResponse(uuid1, uuid2);
    }

    @GetMapping("/findAll")
    public List<Poll> findAll() {
        pollRepository.findAll().forEach(System.out::println);
        return (List<Poll>) pollRepository.findAll();
    }

    /*
    @GetMapping("/getByID/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
        Optional<Poll> one_poll = pollRepository.findById(id);
        return one_poll.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

     */



    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestBody int aid){
        Optional<Answer> answer = answerRepository.findById(aid);
        if(answer.isPresent()) {
            Answer real = answer.get();
        real.setVotes(real.getVotes() + 1);
        answerRepository.save(real);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }








}
