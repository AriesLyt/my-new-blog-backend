package com.blog.backend.dao.blog;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "blog")
@Data
public class BlogDetailDao {

    @Id
    private Integer id;
    private String title;
    private String content;
    private String author;
    private String tags;
    private Long createTime;
    private Long updateTime;

}
