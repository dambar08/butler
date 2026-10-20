package com.butler.app.repositories;

import com.butler.app.entities.MonobankItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonobankItemRepository extends JpaRepository<MonobankItem, UUID> {
}
