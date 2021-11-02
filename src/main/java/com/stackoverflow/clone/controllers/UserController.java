package com.stackoverflow.clone.controllers;


import com.stackoverflow.clone.DTO.ResponseDTO;
import com.stackoverflow.clone.models.User;
import com.stackoverflow.clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "https://localhost:8080")
@RestController
@RequestMapping("/api/stack-overflow/user")
public class UserController {


    /**
     * API's
     * https://localhost:8080//api/stack-overflow/user/save
     * https://localhost:8080//api/stack-overflow/user/edit
     * https://localhost:8080//api/stack-overflow/user/get
     * https://localhost:8080//api/stack-overflow/user/delete
     */

    @Autowired
    UserService userService;


    /**
     *
     * @param user
     * @return ResponseEntity< ResponseDTO<User>>
     * @description save the user to mongo
     *
     */
    @PostMapping("/save")
    public ResponseEntity< ResponseDTO<User>> saveUser(
            @RequestBody User user
    ){
        try {
            ResponseDTO<User> responseDTO  = userService.saveUser(user);
            return new ResponseEntity<>(responseDTO , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    /**
     *
     * @param userId
     * @return ResponseEntity<ResponseDTO<User>>
     * @description get the user from the mongo
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO<User>> getUser(
            @RequestParam(required = true) String userId
    ){
        try{
            ResponseDTO<User> user = userService.getUser(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param user
     * @param userId
     * @return ResponseEntity<ResponseDTO<User>>
     * @description update the user from the mongo
     */
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO<User>> updateUser(
            @RequestBody User user,
            @RequestParam(required = true) String userId
    ){
        try{
            ResponseDTO<User> updatedUser = userService.updateUser(user, userId);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param userId
     * @return ResponseEntity<ResponseDTO<User>>
     * @description delete the user from the mongo
     */
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO<User>> deleteUser(
            @RequestParam(required = true) String userId
    ){
        try{
            ResponseDTO<User> user = userService.deleteUser(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
