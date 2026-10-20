package com.butler.app.repositories;

import com.butler.app.entities.SnaptradeItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnaptradeItemRepository extends JpaRepository<SnaptradeItem, UUID> {
}
