package com.radwija.xyzcarportal.service;

import com.radwija.xyzcarportal.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void register(User user);
    Boolean isValidUser(String username, String password);
}
