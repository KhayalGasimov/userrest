//package com.company.web;
//
//
//import com.company.service.UserService;
//import com.company.entity.User;
//import com.company.exception.RecordNotfoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//    @Autowired
//    UserService service;
//
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> list = service.getAllUsers();
//
//        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
//            throws RecordNotfoundException {
//        User entity = service.getUserById();
//
//        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
//    }
//
//    @PostMapping("/user")
//    public ResponseEntity<User> createOrUpdateUser(User user)
//            throws RecordNotfoundException {
//        User updated = service.createOrUpdateUser(user);
//        return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus deleteUserById(@PathVariable("id") int id)
//            throws RecordNotfoundException {
//        service.deleteById(id);
//        return HttpStatus.FORBIDDEN;
//    }
//
//}
//
