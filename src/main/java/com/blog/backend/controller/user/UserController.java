package com.blog.backend.controller.user;

import com.blog.backend.dto.user.LoginDto;
import com.blog.backend.dto.user.RegisterDto;
import com.blog.backend.entity.user.UserEntity;
import com.blog.backend.service.user.LoginService;
import com.blog.backend.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private LoginService loginService;
    private RegisterService registerService;

    @Autowired
    private void init (
            LoginService loginService,
            RegisterService registerService
    ) {
        this.loginService = loginService;
        this.registerService = registerService;
    }

    @RequestMapping("/login")
    public String login(
            @RequestBody LoginDto loginDto
    ) {
        return loginService.login(loginDto);
    }

    @RequestMapping("/register")
    public String Register(
            @RequestBody RegisterDto registerDto
    ) {
        return registerService.register(registerDto);
    }
}
