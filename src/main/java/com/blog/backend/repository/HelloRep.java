package com.blog.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.backend.dao.HelloDao;

public interface HelloRep extends MongoRepository<HelloDao, String> {

}