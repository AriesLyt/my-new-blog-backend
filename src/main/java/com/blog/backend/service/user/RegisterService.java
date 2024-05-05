package com.blog.backend.service.user;

import com.blog.backend.utils.exception.CustomException;
import com.blog.backend.utils.response.ApiResponse;
import com.blog.backend.dto.user.RegisterDto;
import com.blog.backend.entity.user.UserEntity;
import com.blog.backend.repository.user.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private UserRep userRep;

    @Autowired
    private void init (UserRep userRep) {
        this.userRep = userRep;
    }

    public ApiResponse<Void> register (RegisterDto registerDto) {
        UserEntity userinfo = userRep.findByUsername(registerDto.getUsername());
        if (userinfo != null) throw new CustomException(ApiResponse.fail().getCode(), "User is exist");
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        userRep.insert(user);
        return ApiResponse.success();
    }
}
