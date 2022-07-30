package com.neoquant.valid.controller;

import com.neoquant.valid.dto.UserRequest;
import com.neoquant.valid.entity.User;
import com.neoquant.valid.exception.UserNotFoundException;
import com.neoquant.valid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(value = "/addUser")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) throws UserNotFoundException {
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable int id) throws UserNotFoundException {
        service.deleteUserById(id);
        return "User Delete with Id is:"+id;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserRequest userRequest, @PathVariable int id) throws UserNotFoundException {
        service.getUserById(id);
        service.saveUser(userRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
