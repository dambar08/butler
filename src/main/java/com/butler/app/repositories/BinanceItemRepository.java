package com.butler.app.repositories;

import com.butler.app.entities.BinanceItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinanceItemRepository extends JpaRepository<BinanceItem, UUID> {
}
