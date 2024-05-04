package com.blog.backend.service.user;

import com.blog.backend.dto.user.LoginDto;
import com.blog.backend.entity.user.UserEntity;
import com.blog.backend.repository.user.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private UserRep userRep;

    @Autowired
    private void init (UserRep userRep) {
        this.userRep = userRep;
    }

    public String login (LoginDto loginDto) {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        UserEntity userinfo = userRep.findByUsername(username);
        if (userinfo == null) return "No user";

        if (!userinfo.getPassword().equals(password)) return "Wrong password";

        return "Login successful";
    }
}
