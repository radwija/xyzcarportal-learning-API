package com.radwija.xyzcarportal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.radwija.xyzcarportal.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    private String username;
    private String name;
    private String email;
//    @JsonIgnore
//    private String password;
    private boolean isMatchesPassword;


}
