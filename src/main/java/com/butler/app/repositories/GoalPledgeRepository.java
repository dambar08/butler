package com.butler.app.repositories;

import com.butler.app.entities.GoalPledge;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalPledgeRepository extends JpaRepository<GoalPledge, UUID> {
}
