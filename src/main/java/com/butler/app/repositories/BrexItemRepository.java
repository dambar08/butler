package com.butler.app.repositories;

import com.butler.app.entities.BrexItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrexItemRepository extends JpaRepository<BrexItem, UUID> {
}
