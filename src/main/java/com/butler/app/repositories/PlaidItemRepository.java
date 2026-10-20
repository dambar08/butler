package com.butler.app.repositories;

import com.butler.app.entities.PlaidItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaidItemRepository extends JpaRepository<PlaidItem, UUID> {
}
