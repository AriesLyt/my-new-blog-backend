package com.blog.backend.repository.user;

import com.blog.backend.entity.user.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRep extends MongoRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
