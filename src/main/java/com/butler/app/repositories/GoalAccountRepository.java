package com.butler.app.repositories;

import com.butler.app.entities.GoalAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalAccountRepository extends JpaRepository<GoalAccount, UUID> {
}
