package com.stackoverflow.clone.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "question")
public class Question {



    /**
     * represents the question collection of mongo
     */
    @Id
    private String questionId;

    private String userId;

    private String title;

    private String body;

    private List<String> tags;

}
