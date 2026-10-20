package com.butler.app.repositories;

import com.butler.app.entities.AkahuAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AkahuAccountRepository extends JpaRepository<AkahuAccount, UUID> {
}
