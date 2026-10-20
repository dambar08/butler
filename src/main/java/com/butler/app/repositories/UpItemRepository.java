package com.butler.app.repositories;

import com.butler.app.entities.UpItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpItemRepository extends JpaRepository<UpItem, UUID> {
}
