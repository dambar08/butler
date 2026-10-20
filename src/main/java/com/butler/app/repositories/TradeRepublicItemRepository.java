package com.butler.app.repositories;

import com.butler.app.entities.TradeRepublicItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepublicItemRepository extends JpaRepository<TradeRepublicItem, UUID> {
}
