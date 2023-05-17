package com.radwija.xyzcarportal.service.impl;

import com.radwija.xyzcarportal.model.User;
import com.radwija.xyzcarportal.repository.UserRepository;
import com.radwija.xyzcarportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean isValidUser(String username, String inputPassword) {

        List<User> users = userRepository.findByUsername(username);

        if (users.size() == 1) {
            User user = users.get(0);
            return user.getPassword().equals(inputPassword);
        } else {
            return false;
        }
    }

    @Override
    public User findByUsername(String username) {
        List<User> users = userRepository.findByUsername(username);
        if (users.size() == 1) {
            return users.get(0);
        } else {
            return null;
        }
    }

}
