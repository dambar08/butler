package com.butler.app.repositories;

import com.butler.app.entities.RedbarkItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedbarkItemRepository extends JpaRepository<RedbarkItem, UUID> {
}
