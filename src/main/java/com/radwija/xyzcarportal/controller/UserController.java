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
    public User register(@RequestBody User user) {
        userService.register(user);
        return user;
    }

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody User user) {
        Boolean isValid = userService.isValidUser(user.getUsername(), user.getPassword());

        if (isValid) {
            User loggedInUser = userService.findByUsername(user.getUsername());
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
   
}
