package com.blog.backend.controller;

import com.blog.backend.service.blog.BlogDetailServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private BlogDetailServer blogDetailServer;

    @Autowired
    private void blogController(BlogDetailServer blogDetailServer) {
        this.blogDetailServer = blogDetailServer;
    }


    @RequestMapping("/detail/add")
    public String blogAddDetail() {
        return blogDetailServer.addDetail();
    }
}
