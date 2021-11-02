package com.stackoverflow.clone.service;

import com.stackoverflow.clone.DTO.ResponseDTO;
import com.stackoverflow.clone.models.User;


public interface UserService {

    ResponseDTO<User> saveUser(User user);

    ResponseDTO<User> getUser(String userId);

    ResponseDTO<User> updateUser(User user, String userId);

    ResponseDTO<User> deleteUser(String userId);

}
