package com.butler.app.repositories;

import com.butler.app.entities.Holding;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldingRepository extends JpaRepository<Holding, UUID> {
}
