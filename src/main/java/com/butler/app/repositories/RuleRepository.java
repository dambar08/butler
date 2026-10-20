package com.butler.app.repositories;

import com.butler.app.entities.Rule;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, UUID> {
}
