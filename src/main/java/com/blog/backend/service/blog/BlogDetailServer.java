package com.blog.backend.service.blog;

import com.blog.backend.dto.blog.BlogDetailDto;
import com.blog.backend.entity.blog.BlogDetailEntity;
import com.blog.backend.repository.blog.BlogDetailRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogDetailServer {

    private BlogDetailRep blogDetailRep;

    @Autowired
    private void blogController(BlogDetailRep blogDetailRep) {
        this.blogDetailRep = blogDetailRep;
    }


    public String addDetail(BlogDetailDto blog) {
        BlogDetailEntity newDetail = new BlogDetailEntity();
//        newDetail.setId(1);
        newDetail.setTitle(blog.getTitle());
        newDetail.setContent(blog.getContent());
        newDetail.setCreateTime(new Date().getTime());
        newDetail.setUpdateTime(new Date().getTime());
        blogDetailRep.insert(newDetail);
        return "server add";
    }
}
