package com.blog.backend.controller.user;

import com.blog.backend.config.cookie.CookieConfig;
import com.blog.backend.utils.jwt.JwtUtils;
import com.blog.backend.utils.jwt.TokenBean;
import com.blog.backend.utils.response.ApiResponse;
import com.blog.backend.dto.user.LoginDto;
import com.blog.backend.dto.user.RegisterDto;
import com.blog.backend.service.user.LoginService;
import com.blog.backend.service.user.RegisterService;
import com.blog.backend.utils.response.ResponseCode;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
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
    public ApiResponse<Void> login(
            @RequestBody LoginDto loginDto,
            HttpServletResponse response
    ) {
        ApiResponse<Void> res = loginService.login(loginDto);
        if (res.getCode() == ResponseCode.SUCCESS.getCode()) {
            TokenBean tokenBean = new TokenBean();
            tokenBean.setUsername(loginDto.getUsername());
            Cookie cookie = new Cookie(CookieConfig.cookieName, JwtUtils.createJwt(tokenBean));
            response.addCookie(cookie);
        }
        return res;
    }

    @RequestMapping("/register")
    public ApiResponse<Void> Register(
            @RequestBody RegisterDto registerDto
    ) {
        return registerService.register(registerDto);
    }
}
