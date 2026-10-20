package com.butler.app.repositories;

import com.butler.app.entities.IbkrItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IbkrItemRepository extends JpaRepository<IbkrItem, UUID> {
}
