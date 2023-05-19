package com.radwija.xyzcarportal.service.impl;

import com.radwija.xyzcarportal.dto.BaseResponseDto;
import com.radwija.xyzcarportal.dto.UserDto;
import com.radwija.xyzcarportal.dto.UserLoginDto;
import com.radwija.xyzcarportal.dto.UserRegisterDto;
import com.radwija.xyzcarportal.model.User;
import com.radwija.xyzcarportal.repository.UserRepository;
import com.radwija.xyzcarportal.service.UserService;
import jakarta.transaction.Transactional;
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
    public BaseResponseDto<?> register(UserRegisterDto userRegisterDto) {
        BaseResponseDto<UserDto> response = new BaseResponseDto<>();

        User user = new User();
        BeanUtils.copyProperties(userRegisterDto, user);

        // Save User
        try {
            user.setPassword(bCryptPasswordEncoder.encode(userRegisterDto.getPassword()));
            User savedUser = userRepository.save(user);

            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(savedUser, userDto);

            // Set Response
            response.setCode(200);
            response.setMessage("Register Berhasil");
            response.setResult(userDto);
            return response;

        } catch (Exception ex) {
            if (ex.getMessage().contains("UK_sb8bbouer5wak8vyiiy4pf2bx")) {
                response.setCode(400);
                response.setMessage("Username " + user.getUsername() + " tidak tersedia");
                response.setResult(null);
                return response;
            } else if (ex.getMessage().contains("UK_ob8kqyqqgmefl0aco34akdtpe")) {
                response.setCode(400);
                response.setMessage("Email " + user.getEmail() + " tidak tersedia");
                response.setResult(null);
                return response;
            }

            response.setCode(400);
            response.setMessage("Gagal untuk mendaftar akun");
            response.setResult(null);
            return response;
        }
    }

    @Override
    public BaseResponseDto<?> findByUsername(UserLoginDto userLoginDto) {
        User user = userRepository.findByUsername(userLoginDto.getUsername());
        UserDto userDto = new UserDto();

        // Check account is exist
        if (user == null) {
            return BaseResponseDto.badRequest("Username atau password salah");
        }

        // Copy Variable Data
        BeanUtils.copyProperties(user, userDto);

        // Setter into DTO
        userDto.setMatchesPassword(bCryptPasswordEncoder.matches(userLoginDto.getPassword(), user.getPassword()));

        // Check Password
        if (!userDto.isMatchesPassword()) {
            return BaseResponseDto.badRequest("Username atau password salah");
        }

        return BaseResponseDto.ok(userDto);
    }

}
