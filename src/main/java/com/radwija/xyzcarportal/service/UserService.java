package com.radwija.xyzcarportal.service;

import com.radwija.xyzcarportal.dto.UserDto;
import com.radwija.xyzcarportal.dto.UserLoginDto;
import com.radwija.xyzcarportal.dto.UserRegisterDto;
import com.radwija.xyzcarportal.model.User;

public interface UserService {
    UserDto register(UserRegisterDto userRegisterDto);
    UserDto findByUsername(UserLoginDto userLoginDto);
}
