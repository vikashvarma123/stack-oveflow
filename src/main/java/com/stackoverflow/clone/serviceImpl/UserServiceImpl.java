package com.stackoverflow.clone.serviceImpl;

import com.stackoverflow.clone.DTO.ErrorDTO;
import com.stackoverflow.clone.DTO.ResponseDTO;
import com.stackoverflow.clone.models.User;
import com.stackoverflow.clone.repository.UserRepository;
import com.stackoverflow.clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseDTO<User> saveUser(User user) {
        ResponseDTO<User> userResponse = new ResponseDTO<>();
        Optional<User> userInfo = userRepository.findById(user.getUserId());
        if(!userInfo.isPresent()){
            User savedUser = userRepository.save(user);
            userResponse.setResult(savedUser);
            userResponse.setResponseStatus("SUCCESS");
            return userResponse;
        }
        userResponse.setResponseStatus("FAILURE");
        userResponse.setError(new ErrorDTO("404", "USER ALREADY EXISTS"));
        return userResponse;
    }

    @Override
    public ResponseDTO<User> getUser(String userId) {
        ResponseDTO<User> userResponse  = new ResponseDTO<>();
        Optional<User> userInfo = userRepository.findById(userId);
        if(userInfo.isPresent()){
            userResponse.setResult(userInfo.get());
            userResponse.setResponseStatus("SUCCESS");
            return userResponse;
        }
        userResponse.setResponseStatus("FAILURE");
        userResponse.setError(new ErrorDTO("404", "USER NOT FOUND"));
        return userResponse;
    }

    @Override
    public ResponseDTO<User> updateUser(User user, String userId) {
        ResponseDTO<User> userResponse  = new ResponseDTO<>();
        Optional<User> userInfo = userRepository.findById(userId);
        if(userInfo.isPresent()){
            User userData = userInfo.get();
            if(isValid(user.getCountry())) userData.setCountry(user.getCountry());
            if(isValid(user.getEmailId())) userData.setEmailId(user.getEmailId());
            if(isValid(user.getMobile()))  userData.setMobile(user.getMobile());
            if(isValid(user.getPassword())) userData.setPassword(user.getPassword());
            if(isValid(user.getUserId())) userData.setUserId(user.getUserId());
            User U = userRepository.save(userData);
            userResponse.setResult(U);
            userResponse.setResponseStatus("SUCCESS");
            return userResponse;
        }
        userResponse.setResponseStatus("FAILURE");
        userResponse.setError(new ErrorDTO("404", "USER NOT FOUND"));
        return userResponse;
    }

    @Override
    public ResponseDTO<User> deleteUser(String userId) {
        ResponseDTO<User> userResponse  = new ResponseDTO<>();
        Optional<User> userInfo = userRepository.findById(userId);
        if(userInfo.isPresent()){
            userRepository.delete(userInfo.get());
            userResponse.setResult(userInfo.get());
            userResponse.setResponseStatus("SUCCESS");
            return userResponse;
        }
        userResponse.setResponseStatus("FAILURE");
        userResponse.setError(new ErrorDTO("404", "USER NOT FOUND"));
        return userResponse;
    }

    private Boolean isValid(String attribute){
        return attribute != null;
    }
}
