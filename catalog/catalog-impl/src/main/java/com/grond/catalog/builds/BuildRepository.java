package com.grond.catalog.builds;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends JpaRepository<BuildEntity, UUID> {
}
