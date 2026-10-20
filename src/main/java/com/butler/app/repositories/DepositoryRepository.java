package com.butler.app.repositories;

import com.butler.app.entities.Depository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositoryRepository extends JpaRepository<Depository, UUID> {
}
