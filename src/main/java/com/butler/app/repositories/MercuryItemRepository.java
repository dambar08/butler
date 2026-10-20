package com.butler.app.repositories;

import com.butler.app.entities.MercuryItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercuryItemRepository extends JpaRepository<MercuryItem, UUID> {
}
