package com.butler.app.repositories;

import com.butler.app.entities.Valuation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValuationRepository extends JpaRepository<Valuation, UUID> {
}
