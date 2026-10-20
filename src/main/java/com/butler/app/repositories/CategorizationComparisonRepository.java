package com.butler.app.repositories;

import com.butler.app.entities.CategorizationComparison;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorizationComparisonRepository extends JpaRepository<CategorizationComparison, UUID> {
}
