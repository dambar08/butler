package com.butler.app.repositories;

import com.butler.app.entities.Budget;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, UUID> {
}
