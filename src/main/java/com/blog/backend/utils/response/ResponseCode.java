package com.blog.backend.utils.response;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(200,"Success"),
    FAILURE(201,"Failure"),

    ERROR(500, "Server error");

    private final int code;
    private final String msg;

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
