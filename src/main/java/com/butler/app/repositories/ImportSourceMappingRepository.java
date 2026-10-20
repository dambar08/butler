package com.butler.app.repositories;

import com.butler.app.entities.ImportSourceMapping;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportSourceMappingRepository extends JpaRepository<ImportSourceMapping, UUID> {
}
