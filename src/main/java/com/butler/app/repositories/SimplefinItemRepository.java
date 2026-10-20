package com.butler.app.repositories;

import com.butler.app.entities.SimplefinItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimplefinItemRepository extends JpaRepository<SimplefinItem, UUID> {
}
