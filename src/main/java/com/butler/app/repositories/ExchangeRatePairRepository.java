package com.butler.app.repositories;

import com.butler.app.entities.ExchangeRatePair;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRatePairRepository extends JpaRepository<ExchangeRatePair, UUID> {
}
