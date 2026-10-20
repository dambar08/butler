package com.butler.app.repositories;

import com.butler.app.entities.QuestradeItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestradeItemRepository extends JpaRepository<QuestradeItem, UUID> {
}
