package com.joaodev.workshop_mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joaodev.workshop_mongo.models.entities.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
