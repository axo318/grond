package com.grond.object.store.binarydocument;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinaryDocumentRepository extends MongoRepository<BinaryDocument, String> {}
