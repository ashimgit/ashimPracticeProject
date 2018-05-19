package com.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pojo.entity.Student;

public interface MyMongoRepo extends MongoRepository<Student, String>{

}
