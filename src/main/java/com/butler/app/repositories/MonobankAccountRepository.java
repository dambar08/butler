package com.butler.app.repositories;

import com.butler.app.entities.MonobankAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonobankAccountRepository extends JpaRepository<MonobankAccount, UUID> {
}
