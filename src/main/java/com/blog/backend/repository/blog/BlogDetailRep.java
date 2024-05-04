package com.blog.backend.repository.blog;

import com.blog.backend.entity.blog.BlogDetailEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogDetailRep extends MongoRepository<BlogDetailEntity, String> {


}
