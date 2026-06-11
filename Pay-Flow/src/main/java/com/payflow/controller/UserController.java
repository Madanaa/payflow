package com.payflow.controller;

import com.payflow.entity.User;
import com.payflow.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    private final UserService userService;

    private static final Logger log =  LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        log.info("Incoming request to save user: {}", user);
        if (user.getUpiId() == null || user.getUpiId().trim().isEmpty()){
            log.info("User's upiId is empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (userService.upiIdExists(user.getUpiId())) {
            log.info("User's upiId already exists: {}", user.getUpiId());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        log.info("Incoming request to get all users");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        log.info("Incoming request to get user by id: {}", id);
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/users/upi/{upiId}")
    public ResponseEntity<User> getUserByUpiId(@PathVariable String upiId) {
        log.info("Incoming request to get user by UPI ID: {}", upiId);
        return userService.findByUpiId(upiId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/users/balance-above/{minBalance}")
    public ResponseEntity<List<User>> getUsersWithBalanceAbove(@PathVariable Double minBalance) {
        log.info("Incoming request to get users with balance above: {}", minBalance);
        return ResponseEntity.ok(userService.getHighBalanceUsers(minBalance));
    }

    @PostMapping("/users/demo/without-request-body")
    public ResponseEntity<User> createUserWithoutRequestBody(User user) {
        log.info("Without @RequestBody, Spring MVC builds this object from request parameters instead of JSON: {}", user);
        return ResponseEntity.ok(user);
    }
}
