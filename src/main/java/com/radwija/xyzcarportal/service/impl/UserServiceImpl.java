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
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean isValidUser(String username, String password) {

        List<User> users = userRepository.findByUsername(username);

        if (users.size() == 1) {
            User user = users.get(0);
            return user.getPassword().equals(password);
        } else {
            return false;
        }
    }

}
