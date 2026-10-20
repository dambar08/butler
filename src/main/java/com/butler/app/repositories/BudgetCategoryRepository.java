package com.butler.app.repositories;

import com.butler.app.entities.BudgetCategory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetCategoryRepository extends JpaRepository<BudgetCategory, UUID> {
}
