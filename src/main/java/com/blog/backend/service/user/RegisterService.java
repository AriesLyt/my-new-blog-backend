package com.blog.backend.service.user;

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

    public String register (RegisterDto registerDto) {
        UserEntity userinfo = userRep.findByUsername(registerDto.getUsername());
        if (userinfo != null) return "User already exist";
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        userRep.insert(user);
        return "Register";
    }
}
