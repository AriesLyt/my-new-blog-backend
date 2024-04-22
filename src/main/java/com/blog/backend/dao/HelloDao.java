package com.blog.backend.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "blogs")
@Data
public class HelloDao {

    @Id
    private String id;
    private String name;
    private String content;
}
