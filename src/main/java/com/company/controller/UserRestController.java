package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.exception.RecordNotfoundException;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired

    UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List> getUsers() {
        Iterable<User> users = userService.getAllUsers();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(new UserDTO(user));
        }
        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") int id) throws RecordNotfoundException {
        User user = userService.findById(id);
        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user)));
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id) throws RecordNotfoundException {
        User user = userService.findById(id);
        userService.deleteById(id);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user), "Successfully deleted"));


    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@PathVariable("id") int id, @RequestBody User user) throws RecordNotfoundException {
        return userService.createOrUpdateUser(id, user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable("id") int id, @RequestBody User userDTO ) throws RecordNotfoundException{

            userService.createOrUpdateUser(id,userDTO);
            return new ResponseEntity<ResponseDTO>(HttpStatus.OK);

//            return new ResponseEntity<ResponseDTO>(HttpStatus.NOT_FOUND);
        }
    }


