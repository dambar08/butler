package com.butler.app.repositories;

import com.butler.app.entities.Goal;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, UUID> {
}
