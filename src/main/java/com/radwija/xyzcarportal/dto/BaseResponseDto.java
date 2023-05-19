package com.radwija.xyzcarportal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
// @DataTypeRoot is generic type (can adjust all object)
public class BaseResponseDto<DataTypeRoot> {
    int code = 403;
    String message = "Unauthorized";
    DataTypeRoot result = null;

    // @DataType is generic type (can adjust all object)
    public static <DataType> BaseResponseDto<DataType> ok(DataType result) {
        BaseResponseDto<DataType> response = new BaseResponseDto<>();
        response.code = 200;
        response.message = "Success";
        response.result = result;
        return response;
    }

    public static BaseResponseDto<?> badRequest(String msg) {
        BaseResponseDto<?> response = new BaseResponseDto<>();
        response.code = 400;
        response.message = msg;
        return response;
    }

    public static BaseResponseDto<?> unauthorized(String msg) {
        BaseResponseDto<?> response = new BaseResponseDto<>();
        response.code = 400;
        response.message = msg;
        return response;
    }

    public static BaseResponseDto<?> unauthorized() {
        BaseResponseDto<?> response = new BaseResponseDto<>();
        response.code = 403;
        return response;
    }
}
