package com.butler.app.repositories;

import com.butler.app.entities.AkahuItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AkahuItemRepository extends JpaRepository<AkahuItem, UUID> {
}
