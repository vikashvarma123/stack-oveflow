package com.stackoverflow.clone.models;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "user")
public class User {

    /**
     * represents the user collection of mongo
     */


    @Id
    private String userId;

    private String emailId;

    private String password;

    private String mobile;

    private String country;

}
