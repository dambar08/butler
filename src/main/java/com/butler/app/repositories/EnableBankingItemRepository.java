package com.butler.app.repositories;

import com.butler.app.entities.EnableBankingItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnableBankingItemRepository extends JpaRepository<EnableBankingItem, UUID> {
}
