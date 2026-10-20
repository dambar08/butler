package com.butler.app.repositories;

import com.butler.app.entities.IndexaCapitalItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndexaCapitalItemRepository extends JpaRepository<IndexaCapitalItem, UUID> {
}
