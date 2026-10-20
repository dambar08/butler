package com.butler.app.repositories;

import com.butler.app.entities.DebugLogEntry;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebugLogEntryRepository extends JpaRepository<DebugLogEntry, UUID> {
}
