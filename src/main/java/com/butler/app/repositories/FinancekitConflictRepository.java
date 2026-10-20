package com.butler.app.repositories;

import com.butler.app.entities.FinancekitConflict;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancekitConflictRepository extends JpaRepository<FinancekitConflict, UUID> {
}
