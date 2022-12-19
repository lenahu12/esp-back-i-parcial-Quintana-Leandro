package com.dh.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.dh.catalog.model.ChapterEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterMongoRepository extends MongoRepository<ChapterEntity, Long> {
}
