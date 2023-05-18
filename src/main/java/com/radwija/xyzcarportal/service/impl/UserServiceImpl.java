package com.radwija.xyzcarportal.service.impl;

import com.radwija.xyzcarportal.dto.UserDto;
import com.radwija.xyzcarportal.dto.UserLoginDto;
import com.radwija.xyzcarportal.dto.UserRegisterDto;
import com.radwija.xyzcarportal.model.User;
import com.radwija.xyzcarportal.repository.UserRepository;
import com.radwija.xyzcarportal.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto register(UserRegisterDto userRegisterDto) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterDto, user);

        // Save User
        try {
            user.setPassword(bCryptPasswordEncoder.encode(userRegisterDto.getPassword()));
            User savedUser = userRepository.save(user);

            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(savedUser, userDto);
            return userDto;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public UserDto findByUsername(UserLoginDto userLoginDto) {
        User user = userRepository.findByUsername(userLoginDto.getUsername());
        UserDto userDto = new UserDto();
        if (user == null) {
            return null;
        }

        // Copy Variable Data
        BeanUtils.copyProperties(user, userDto);

        // Setter into DTO
        userDto.setMatchesPassword(bCryptPasswordEncoder.matches(userLoginDto.getPassword(), user.getPassword()));

        // Check Password
        if (!userDto.isMatchesPassword()) {
            return null;
        }

        return userDto;
    }

}
