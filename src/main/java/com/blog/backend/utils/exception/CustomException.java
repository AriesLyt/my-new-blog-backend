package com.blog.backend.utils.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
public class CustomException extends RuntimeException {

    @Setter
    private int code;
    private final String msg;

    public CustomException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public CustomException(int code, String msg) {
        this(code, msg, null);
    }


}
