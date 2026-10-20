package com.butler.app.repositories;

import com.butler.app.entities.FamilyExport;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyExportRepository extends JpaRepository<FamilyExport, UUID> {
}
