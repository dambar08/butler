package com.butler.app.repositories;

import com.butler.app.entities.KrakenItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KrakenItemRepository extends JpaRepository<KrakenItem, UUID> {
}
