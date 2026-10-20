package com.butler.app.repositories;

import com.butler.app.entities.RecurringMatchRejection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecurringMatchRejectionRepository extends JpaRepository<RecurringMatchRejection, UUID> {
}
