package com.blog.backend.dto.blog;

import lombok.Data;

@Data
public class BlogDetailDto {

    private String title;
    private String content;
    private String author;
    private String tag;

}
