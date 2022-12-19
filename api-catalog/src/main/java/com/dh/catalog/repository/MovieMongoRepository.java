package com.dh.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.dh.catalog.model.MovieEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMongoRepository extends MongoRepository<MovieEntity, Long> {
}
