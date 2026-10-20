package com.butler.app.repositories;

import com.butler.app.entities.AccountStatement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStatementRepository extends JpaRepository<AccountStatement, UUID> {
}
