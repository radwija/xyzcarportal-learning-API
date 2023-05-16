package com.radwija.xyzcarportal.controller;

import com.radwija.xyzcarportal.model.User;
import com.radwija.xyzcarportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public String register(@RequestBody User user) {
        userService.register(user);
        return "Register successfully!";
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserLogin userlogin) {
        Boolean isValid = userService.isValidUser(userlogin.getUsername(), userlogin.getPassword());

        if (isValid) {
            return ResponseEntity.ok("Login succcessfully!");
        } else {
            return ResponseEntity.badRequest().body("Incorrect credential!");
        }
    }
    private static class UserLogin {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
