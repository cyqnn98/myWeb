package com.yqcui.yqweb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqcui.yqweb.entity.User;
import com.yqcui.yqweb.service.UserService;
import com.yqcui.yqweb.utils.Result;
import com.yqcui.yqweb.utils.TokenProcessor;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController{
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User userSaved = userService.saveUser(user);
        if(userSaved == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        if(!userService.existsUser(user)){
            return Result.error().setMessage("User doesn't exist");
        }
        if(!userService.passwordMatched(user)){
            return Result.error().setMessage("Wrong password");
        }
        String token = TokenProcessor.createToken(user.getEmail());
        return Result.ok().data("token", token);
    }

    @PostMapping("/info")
    public Result getInfo(@RequestBody String token){
        System.out.println("here");
        System.out.println(token);
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            JsonNode jsonNode = objectMapper.readTree(token);
//            token = jsonNode.get("token").asText();
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        Claims email = TokenProcessor.verify(token);
        System.out.println("Email decrypted by token is" + email.getSubject());
        return Result.ok().data("userInfo", userService.getUserByEmail(email.getSubject()));
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}