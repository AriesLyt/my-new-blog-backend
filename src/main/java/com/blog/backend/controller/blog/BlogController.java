package com.blog.backend.controller.blog;

import com.blog.backend.dto.blog.BlogDetailDto;
import com.blog.backend.service.blog.BlogDetailServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String blogAddDetail(
        @RequestBody BlogDetailDto blog
    ) {
        return blogDetailServer.addDetail(blog);
    }
}
