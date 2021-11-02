package com.stackoverflow.clone.service;

import com.stackoverflow.clone.DTO.ResponseDTO;
import com.stackoverflow.clone.models.Answer;
import com.stackoverflow.clone.models.Question;

public interface QuestionService {

    ResponseDTO<Question> saveQuestion(Question question);

    ResponseDTO<Question> editQuestion(Question question, String questionId);

}
