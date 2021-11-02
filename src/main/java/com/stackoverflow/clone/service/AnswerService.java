package com.stackoverflow.clone.service;


import com.stackoverflow.clone.DTO.ResponseDTO;
import com.stackoverflow.clone.models.Answer;

public interface AnswerService {

    ResponseDTO<Answer> saveAnswer(Answer answer);

    ResponseDTO<Answer> voteAnswer(String answerId);

    ResponseDTO<Answer> acceptAnswer(String questionId, String answerId, String userId);
}
