package com.butler.app.repositories;

import com.butler.app.entities.BudgetShare;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetShareRepository extends JpaRepository<BudgetShare, UUID> {
}
