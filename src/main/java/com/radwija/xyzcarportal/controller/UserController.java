package com.radwija.xyzcarportal.controller;

import com.radwija.xyzcarportal.dto.BaseResponseDto;
import com.radwija.xyzcarportal.dto.UserDto;
import com.radwija.xyzcarportal.dto.UserLoginDto;
import com.radwija.xyzcarportal.dto.UserRegisterDto;
import com.radwija.xyzcarportal.model.User;
import com.radwija.xyzcarportal.service.UserService;
import com.radwija.xyzcarportal.service.impl.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDto userRegisterDto) {
        final BaseResponseDto<?> response = userService.register(userRegisterDto);

        if (response.getCode() == 400) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto) {
        final BaseResponseDto<?> response = userService.findByUsername(userLoginDto);

        if (response.getCode() == 400) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

}
