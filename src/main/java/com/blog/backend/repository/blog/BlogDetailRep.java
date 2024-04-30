package com.blog.backend.repository.blog;

import com.blog.backend.dao.blog.BlogDetailDao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogDetailRep extends MongoRepository<BlogDetailDao, String> {


}
