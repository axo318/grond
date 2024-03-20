package com.grond.object.store.binarystore;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinaryStoreRepository extends CrudRepository<BinaryStore, String> {}
