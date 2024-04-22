package com.blog.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.backend.dao.HelloDao;
import com.blog.backend.repository.HelloRep;

@RestController
public class HelloController {

    private HelloRep helloRep;

    @Autowired
    public void helloController(HelloRep helloRep) {
        this.helloRep = helloRep;
    }

    @GetMapping("/hello")
    public String hello() {
        HelloDao h = new HelloDao();
        h.setId("1");
        h.setName("1");
        h.setContent("1");
        helloRep.save(h);
        return "hello";
    }
}
