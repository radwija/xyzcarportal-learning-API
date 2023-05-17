package com.radwija.xyzcarportal.service;

import com.radwija.xyzcarportal.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User register(User user);
    Boolean isValidUser(String username, String inputPassword);

    User findByUsername(String username);
}
