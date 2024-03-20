package com.grond.object.store.jsonstore;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JsonStoreRepository extends MongoRepository<JsonStore, String> {}
