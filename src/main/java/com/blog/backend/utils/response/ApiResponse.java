package com.blog.backend.utils.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    private ApiResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ApiResponse(int code, String msg, T data) {
        this(code, msg);
        this.data = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg());
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

    public static <T> ApiResponse<T> fail() {
        return new ApiResponse<>(ResponseCode.FAILURE.getCode(), ResponseCode.FAILURE.getMsg());
    }

    public static <T> ApiResponse<T> error() {
        return new ApiResponse<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMsg());
    }

    public static <T> ApiResponse<T> error(int code, String msg) {
        return new ApiResponse<>(code, msg);
    }

}
