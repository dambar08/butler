package com.butler.app.repositories;

import com.butler.app.entities.FinancekitTransaction;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancekitTransactionRepository extends JpaRepository<FinancekitTransaction, UUID> {
}
