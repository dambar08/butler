package com.butler.app.repositories;

import com.butler.app.entities.WiseItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WiseItemRepository extends JpaRepository<WiseItem, UUID> {
}
