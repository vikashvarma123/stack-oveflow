# stack-oveflow

Technologies Used : Spring Boot(Java Framework), MongoDB 

API's Involved: 

USER API's 

https://localhost:8080//api/stack-overflow/user/save - Save the User to the MongoDB 

Request Body - 
{
    "userId": "Vikash143", "emailId": "vikash143@gmail.com", "password": "Vikash@143", "mobile": "9900223456", "country": "INDIA"
}
No Params required 

NOTE : userId is unique, it won't allows duplicate userIds   

Success Response : If user Id is unique and non-empty 
Failure Response : If user Id is non unique 


https://localhost:8080//api/stack-overflow/user/edit - Edit the User in MongoDB 
Request Body - 
{
    "userId": "Vikash143", "emailId": "vikash143@gmail.com", "password": "Vikash@143", "mobile": "9900223456", "country": "INDIA"
}
Request Param : userId 

NOTE : userId is unique, it won't allows duplicate userIds   


https://localhost:8080//api/stack-overflow/user/get - Get the User from MongoDB

RequestParam : userId 

Success Response : If user Id exists
Failure Response : If user Id is not present


https://localhost:8080//api/stack-overflow/user/delete - Delete the User from MongoDB

RequestParam : userId 

Success Response : If user Id exists
Failure Response : If user Id is not present


Question API's 

https://localhost:8080//api/stack-overflow/question/save

Request Body : 
{
    "questionId": "QUES1", "userId": "Vikash123", "title": "Can we implement Virtual functions in C++", "body": "blah blha blah blah ",
    "tags": ["C++", "Virtual Functions","Programming", "Knowledge"]
}
No Params required
Success: If question Id is unique
FAILURE : If question Id is duplicated 

https://localhost:8080//api/stack-overflow/question/edit
Request Body : 
{
    "questionId": "QUES1", "userId": "Vikash123", "title": "Can we implement Virtual functions in C++", "body": "blah blha blah blah ",
    "tags": ["C++", "Virtual Functions","Programming", "Knowledge"]
}
Request Param - questionId 


Answer API's 

https://localhost:8080//api/stack-overflow/answer/save

Request Body - 
{
    "answerId": "ANS1", "questionId": "QUES1", "answer": "We can Implement", "votes": 0, "isAccepted": false, "userId": "Vikky123"
}
No Request Params 
Success: If answer Id is unique and saved successfully to DB 
Failure : If answer Id is duplicated 


https://localhost:8080//api/stack-overflow/answer/vote
@RequestParam : answerId 
Any user can vote the answer 

https://localhost:8080//api/stack-overflow/answer/accept
@RequestParam : answerId, questionId, userId 
Only the questionPostedUser can accept the answer



