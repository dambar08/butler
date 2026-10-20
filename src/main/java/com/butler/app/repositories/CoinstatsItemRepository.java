package com.butler.app.repositories;

import com.butler.app.entities.CoinstatsItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinstatsItemRepository extends JpaRepository<CoinstatsItem, UUID> {
}
