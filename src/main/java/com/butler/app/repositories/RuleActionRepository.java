package com.butler.app.repositories;

import com.butler.app.entities.RuleAction;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleActionRepository extends JpaRepository<RuleAction, UUID> {
}
