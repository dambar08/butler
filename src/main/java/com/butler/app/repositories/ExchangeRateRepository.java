package com.butler.app.repositories;

import com.butler.app.entities.ExchangeRate;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, UUID> {
}
