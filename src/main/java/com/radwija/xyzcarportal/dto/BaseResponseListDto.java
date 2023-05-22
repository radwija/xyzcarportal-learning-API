package com.radwija.xyzcarportal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BaseResponseListDto<DataType> {
    int code;
    String message;
    List<DataType> result;
}
