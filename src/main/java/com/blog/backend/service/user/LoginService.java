package com.blog.backend.service.user;

import com.blog.backend.utils.exception.CustomException;
import com.blog.backend.utils.response.ApiResponse;
import com.blog.backend.utils.response.ResponseCode;
import com.blog.backend.dto.user.LoginDto;
import com.blog.backend.entity.user.UserEntity;
import com.blog.backend.repository.user.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private UserRep userRep;

    @Autowired
    private void init (UserRep userRep) {
        this.userRep = userRep;
    }

    public ApiResponse<Void> login (LoginDto loginDto) {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        UserEntity userinfo = userRep.findByUsername(username);
        if (userinfo == null) throw new CustomException(ResponseCode.FAILURE.getCode(), "No User");

        if (!userinfo.getPassword().equals(password))  throw new CustomException(ResponseCode.FAILURE.getCode(), "Wrong password");

        return ApiResponse.success();
    }
}
