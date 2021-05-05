package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.exception.RecordNotfoundException;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {

    @Autowired

    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List> getUsers(){
    List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(int i=0;i<users.size();i++){
            User u = users.get(i);
            userDTOS.add(new UserDTO(u));
        }
        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable ("id") int id ) throws RecordNotfoundException {
        User user = userService.findById(id);
        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user)));
    }

//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id){
//        User user = userService.findById(id);
//        userService.deleteById(id);
//
//        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user),"Successfully deleted"));



//    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id) throws RecordNotfoundException {
//        User user = userService.getUserById();
//        userService.deleteById((long) id);
//
//        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user),"Successfully deleted"));
//
//    }
//    @PostMapping("/users/post")
////    public @ResponseBody ResponseEntity<ResponseDTO> post() {
////        return new ResponseEntity(ResponseDTO.of("POST Response"), HttpStatus.OK);
//////    @PostMapping("/users/")
//    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDto){
//        User user = new User();
//        user.setName(userDto.getName());
//        user.setSurname(userDto.getSurname());
//        user.setEmail(userDto.getEmail());
//
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setSurname(user.getSurname());
//        userDTO.setEmail(user.getEmail());
//
//        return ResponseEntity.ok(ResponseDTO.of(userDTO,"Successfully added"));
//    }
}

