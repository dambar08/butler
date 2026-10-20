package com.butler.app.repositories;

import com.butler.app.entities.Balance;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, UUID> {
}
