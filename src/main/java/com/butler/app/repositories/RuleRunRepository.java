package com.butler.app.repositories;

import com.butler.app.entities.RuleRun;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRunRepository extends JpaRepository<RuleRun, UUID> {
}
