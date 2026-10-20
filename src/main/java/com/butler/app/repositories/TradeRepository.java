package com.butler.app.repositories;

import com.butler.app.entities.Trade;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, UUID> {
}
