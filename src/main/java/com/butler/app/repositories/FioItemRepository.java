package com.butler.app.repositories;

import com.butler.app.entities.FioItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FioItemRepository extends JpaRepository<FioItem, UUID> {
}
