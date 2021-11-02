package com.stackoverflow.clone.serviceImpl;

import com.stackoverflow.clone.DTO.ErrorDTO;
import com.stackoverflow.clone.DTO.ResponseDTO;
import com.stackoverflow.clone.models.Answer;
import com.stackoverflow.clone.models.Question;
import com.stackoverflow.clone.repository.QuestionRepository;
import com.stackoverflow.clone.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class QuestionServiceImpl implements QuestionService {


    @Autowired
    QuestionRepository questionRepository;

    @Override
    public ResponseDTO<Question> saveQuestion(Question question) {
        ResponseDTO<Question> response = new ResponseDTO<>();
        Optional<Question> questionInfo = questionRepository.findById(question.getQuestionId());
        if(!questionInfo.isPresent()){
            Question questionObj = questionRepository.save(question);
            response.setResult(questionObj);
            response.setResponseStatus("SUCCESS");
            return response;
        }
        response.setError(new ErrorDTO("400", "QUESTION ALREADY EXISTS"));
        response.setResponseStatus("FAILURE");
        return response;
    }

    @Override
    public ResponseDTO<Question> editQuestion(Question question, String questionId) {
        ResponseDTO<Question> response = new ResponseDTO<>();
        Optional<Question> questionInfo = questionRepository.findById(question.getQuestionId());
        if(questionInfo.isPresent()){
            Question Q = questionInfo.get();
            if(question.getTitle() != null) Q.setTitle(question.getTitle());
            if(question.getBody() != null) Q.setBody(question.getBody());
            Question questionObj = questionRepository.save(Q);
            response.setResult(questionObj);
            response.setResponseStatus("SUCCESS");
            return response;
        }
        response.setError(new ErrorDTO("400", "QUESTION NOT FOUND"));
        response.setResponseStatus("FAILURE");
        return response;
    }


}
