package com.radwija.xyzcarportal.service;

import com.radwija.xyzcarportal.dto.BaseResponseDto;
import com.radwija.xyzcarportal.dto.UserDto;
import com.radwija.xyzcarportal.dto.UserLoginDto;
import com.radwija.xyzcarportal.dto.UserRegisterDto;
import com.radwija.xyzcarportal.model.User;

public interface UserService {
    BaseResponseDto<?> register(UserRegisterDto userRegisterDto);
    BaseResponseDto<?> findByUsername(UserLoginDto userLoginDto);
}
