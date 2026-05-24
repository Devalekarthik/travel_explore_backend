package com.travel.backend.content;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContentRepository extends MongoRepository<ContentDocument, String> {}

