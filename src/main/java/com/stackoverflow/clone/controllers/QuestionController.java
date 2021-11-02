package com.stackoverflow.clone.controllers;


import com.stackoverflow.clone.DTO.ResponseDTO;
import com.stackoverflow.clone.models.Answer;
import com.stackoverflow.clone.models.Question;
import com.stackoverflow.clone.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:8080")
@RestController
@RequestMapping("/api/stack-overflow/question")
public class QuestionController {

    /**
     * API's
     * https://localhost:8080//api/stack-overflow/question/save
     * https://localhost:8080//api/stack-overflow/question/edit
     */

    @Autowired
    QuestionService questionService;

    /**
     *
     * @param question
     * @return ResponseEntity<ResponseDTO<Question>>
     * @description save the question to mongo
     */
    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<Question>> saveQuestion(
            @RequestBody Question question
    ){
        try {
            ResponseDTO<Question> responseDTO  = questionService.saveQuestion(question);
            return new ResponseEntity<>(responseDTO , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    /**
     *
     * @param question
     * @param questionId
     * @return ResponseEntity<ResponseDTO<Question>>
     * @description update the question in mongo
     */
    @PutMapping("/edit")
    public ResponseEntity<ResponseDTO<Question>> editQuestion(
            @RequestBody Question question,
            @RequestParam String questionId
    ){
        try {
            ResponseDTO<Question> responseDTO  = questionService.editQuestion(question, questionId);
            return new ResponseEntity<>(responseDTO , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
