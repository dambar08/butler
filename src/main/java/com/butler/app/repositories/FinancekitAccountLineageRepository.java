package com.butler.app.repositories;

import com.butler.app.entities.FinancekitAccountLineage;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancekitAccountLineageRepository extends JpaRepository<FinancekitAccountLineage, UUID> {
}
