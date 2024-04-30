package com.blog.backend.service.blog;

import com.blog.backend.dao.blog.BlogDetailDao;
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


    public String addDetail() {
        BlogDetailDao newDetail = new BlogDetailDao();
        newDetail.setId(1);
        newDetail.setTitle("Test");
        newDetail.setContent("T");
        newDetail.setCreateTime(new Date().getTime());
        newDetail.setUpdateTime(new Date().getTime());
        blogDetailRep.insert(newDetail);
        return "server add";
    }
}
