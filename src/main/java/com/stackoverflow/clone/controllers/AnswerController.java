package com.stackoverflow.clone.controllers;


import com.stackoverflow.clone.DTO.ResponseDTO;
import com.stackoverflow.clone.models.Answer;
import com.stackoverflow.clone.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:8080")
@RestController
@RequestMapping("/api/stack-overflow/answer")
public class AnswerController {


    /**
     * API's
     * https://localhost:8080//api/stack-overflow/answer/save
     * https://localhost:8080//api/stack-overflow/answer/vote
     * https://localhost:8080//api/stack-overflow/answer/accept
     */


    @Autowired
    AnswerService answerService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<Answer>> saveAnswer(
        @RequestBody Answer answer
    ){
        try {
            ResponseDTO<Answer> responseDTO  = answerService.saveAnswer(answer);
            return new ResponseEntity<>(responseDTO , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/vote")
    public ResponseEntity<ResponseDTO<Answer>> voteAnswer(
            @RequestParam String answerId
    ){
        try {
            ResponseDTO<Answer> responseDTO  = answerService.voteAnswer(answerId);
            return new ResponseEntity<>(responseDTO , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/accept")
    public ResponseEntity<ResponseDTO<Answer>> acceptAnswer(
            @RequestParam String questionId,
            @RequestParam String answerId,
            @RequestParam String userId
    ){
        try {
            ResponseDTO<Answer> responseDTO  = answerService.acceptAnswer(questionId, answerId, userId);
            return new ResponseEntity<>(responseDTO , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
