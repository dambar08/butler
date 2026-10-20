package com.butler.app.repositories;

import com.butler.app.entities.RecurringPriceChange;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecurringPriceChangeRepository extends JpaRepository<RecurringPriceChange, UUID> {
}
