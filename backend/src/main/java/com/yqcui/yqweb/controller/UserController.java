package com.yqcui.yqweb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqcui.yqweb.entity.User;
import com.yqcui.yqweb.service.CartService;
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
    private CartService cartService;

    public UserController(UserService userService, CartService cartService){
        this.userService = userService;
        this.cartService = cartService;
    }
    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User userSaved = userService.saveUser(user);
        if(userSaved == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            Long userId = userSaved.getUserId();
            System.out.println("here");
            cartService.insertCartByUserId(userId);
            return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
        }
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
        Long userId = userService.getUserByEmail(user.getEmail()).getUserId();
        return Result.ok().data("token", token).data("userId", userId);
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