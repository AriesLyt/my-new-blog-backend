package com.blog.backend.entity.user;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
public class UserEntity {

    private String username;
    private String password;
}
