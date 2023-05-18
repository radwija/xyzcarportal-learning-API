package com.radwija.xyzcarportal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRegisterDto {
    private String username;
    private String password;
    private String name;
    private String email;
}
