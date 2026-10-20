package com.butler.app.repositories;

import com.butler.app.entities.RuleCondition;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleConditionRepository extends JpaRepository<RuleCondition, UUID> {
}
