package com.radwija.xyzcarportal.controller;

import com.radwija.xyzcarportal.model.User;
import com.radwija.xyzcarportal.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("register")
    public String register(@RequestBody User user) {
        userService.register(user);
        return "Register successfully!";
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Boolean isValid = userService.isValidUser(user.getUsername(), user.getPassword());

        if (isValid) {
            return ResponseEntity.ok("Login successfully!");
        } else {
            return ResponseEntity.badRequest().body("Incorrect credential!");
        }
    }
   
}
