package com.butler.app.repositories;

import com.butler.app.entities.RecurringAllocation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecurringAllocationRepository extends JpaRepository<RecurringAllocation, UUID> {
}
