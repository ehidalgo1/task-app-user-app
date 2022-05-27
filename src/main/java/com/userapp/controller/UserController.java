package com.userapp.controller;

import com.userapp.dto.UserDto;
import com.userapp.model.User;
import com.userapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getAllUser(){
        logger.info("Invocando metodo getAllUser");
        return userService.findAll();
    }

    @GetMapping("/{uuid}")
    public UserDto getUserByUuid(@PathVariable String uuid){
        return userService.findByUuid(uuid);
    }

    @GetMapping("/id/{id}")
    public UserDto getUserById(@PathVariable Long id){
        logger.info("Invocando metodo getUserById");
        return userService.findById(id);
    }

    @PostMapping
    public UserDto postUser(@RequestBody User user){
        logger.info("Invocando método postUser");
        return userService.saveUser(user);
    }



}
