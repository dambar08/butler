package com.butler.app.repositories;

import com.butler.app.entities.FinancekitBalanceObservation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancekitBalanceObservationRepository extends JpaRepository<FinancekitBalanceObservation, UUID> {
}
