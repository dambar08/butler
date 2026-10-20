package com.butler.app.repositories;

import com.butler.app.entities.RecurrenceRule;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecurrenceRuleRepository extends JpaRepository<RecurrenceRule, UUID> {
}
