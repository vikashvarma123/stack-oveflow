package com.stackoverflow.clone.repository;

import com.stackoverflow.clone.models.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerRepository extends MongoRepository<Answer, String> {

}
