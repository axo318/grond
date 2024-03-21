package com.grond.object.store.jsondocument;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JsonDocumentRepository extends MongoRepository<JsonDocument, String> {}
