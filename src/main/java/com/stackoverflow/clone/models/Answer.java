package com.stackoverflow.clone.models;


import lombok.Data;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "answer")
public class Answer {


    /**
     * represents the answer collection of mongo
     */

    @Id
    private String answerId;

    private String questionId;

    private String userId;

    private String answer;

    private Integer votes;

    private Boolean isAccepted = false;

}
