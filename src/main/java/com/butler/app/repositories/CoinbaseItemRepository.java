package com.butler.app.repositories;

import com.butler.app.entities.CoinbaseItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinbaseItemRepository extends JpaRepository<CoinbaseItem, UUID> {
}
