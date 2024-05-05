package com.blog.backend.utils.exception;

import com.blog.backend.utils.response.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public ApiResponse<Void> exception() {
        return ApiResponse.error();
    }

    @ExceptionHandler(value = CustomException.class)
    public ApiResponse<Void> customException(CustomException e) {
        return ApiResponse.error(e.getCode(), e.getMsg());
    }
}
