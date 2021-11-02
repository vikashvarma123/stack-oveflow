package com.stackoverflow.clone.serviceImpl;

import com.stackoverflow.clone.DTO.ErrorDTO;
import com.stackoverflow.clone.DTO.ResponseDTO;
import com.stackoverflow.clone.models.Answer;
import com.stackoverflow.clone.models.Question;
import com.stackoverflow.clone.repository.AnswerRepository;
import com.stackoverflow.clone.repository.QuestionRepository;
import com.stackoverflow.clone.service.AnswerService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AnswerServiceImpl implements AnswerService {


    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public ResponseDTO<Answer> saveAnswer(Answer answer) {
        ResponseDTO<Answer> response = new ResponseDTO<>();
        if(answer != null){
            Answer savedAnswer = answerRepository.save(answer);
            response.setResponseStatus("SUCCESS");
            response.setResult(savedAnswer);
            return response;
        }
        response.setResponseStatus("FAILURE");
        response.setError(new ErrorDTO("400", "Invalid Answer Object"));
        return response;
    }

    @Override
    public ResponseDTO<Answer> voteAnswer(String answerId) {
        ResponseDTO<Answer> response = new ResponseDTO<>();
        val answerInfo = answerRepository.findById(answerId);
        if(answerInfo.isPresent()){
            Answer answerDetail = answerInfo.get();
            System.out.println("Answer "+ answerDetail.toString());
            answerDetail.setVotes(answerDetail.getVotes() + 1);
            Answer savedAnswer = answerRepository.save(answerDetail);
            response.setResponseStatus("SUCCESS");
            response.setResult(savedAnswer);
            return response;
        }
        response.setResponseStatus("FAILURE : ANSWER NOT FOUND ");
        response.setError(new ErrorDTO("404", "ANSWER NOT FOUND"));
        return response;

    }

    @Override
    public ResponseDTO<Answer> acceptAnswer(String questionId, String answerId, String userId){
        ResponseDTO<Answer> response = new ResponseDTO<>();
        Optional<Answer> answerInfo = answerRepository.findById(answerId);
        Optional<Question> questionInfo = questionRepository.findById(questionId);
        if(questionInfo.isPresent()) {
            String questionPostedUser = questionInfo.get().getUserId();
            Answer answer = answerInfo.get();
            if (questionPostedUser.compareTo(userId) == 0) {
                answer.setIsAccepted(true);
                Answer updatedAnswer = answerRepository.save(answer);
                response.setResponseStatus("SUCCESS");
                response.setResult(updatedAnswer);
            } else {
                response.setResponseStatus("FAILURE");
                response.setError(new ErrorDTO("400", ": Only Question Posted User can accept the answer"));
            }
            return response;
        }
        response.setResponseStatus("FAILURE : QUESTION NOT FOUND ");
        response.setError(new ErrorDTO("404", "QUESTION NOT FOUND"));
        return response;
    }


}
