package com.butler.app.repositories;

import com.butler.app.entities.FinancekitItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancekitItemRepository extends JpaRepository<FinancekitItem, UUID> {
}
