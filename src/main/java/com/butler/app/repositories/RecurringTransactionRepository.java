package com.butler.app.repositories;

import com.butler.app.entities.RecurringTransaction;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecurringTransactionRepository extends JpaRepository<RecurringTransaction, UUID> {
}
