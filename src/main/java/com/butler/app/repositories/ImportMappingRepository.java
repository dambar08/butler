package com.butler.app.repositories;

import com.butler.app.entities.ImportMapping;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportMappingRepository extends JpaRepository<ImportMapping, UUID> {
}
