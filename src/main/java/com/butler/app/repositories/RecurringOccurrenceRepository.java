package com.butler.app.repositories;

import com.butler.app.entities.RecurringOccurrence;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecurringOccurrenceRepository extends JpaRepository<RecurringOccurrence, UUID> {
}
