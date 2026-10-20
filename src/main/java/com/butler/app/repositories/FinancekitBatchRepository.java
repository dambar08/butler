package com.butler.app.repositories;

import com.butler.app.entities.FinancekitBatch;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancekitBatchRepository extends JpaRepository<FinancekitBatch, UUID> {
}
