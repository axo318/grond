package com.grond.object.store.binarystore;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinaryStoreRepository extends MongoRepository<BinaryStore, String> {}
