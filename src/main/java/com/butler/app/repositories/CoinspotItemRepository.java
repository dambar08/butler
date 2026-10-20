package com.butler.app.repositories;

import com.butler.app.entities.CoinspotItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinspotItemRepository extends JpaRepository<CoinspotItem, UUID> {
}
