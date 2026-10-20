package com.butler.app.repositories;

import com.butler.app.entities.PlaidAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaidAccountRepository extends JpaRepository<PlaidAccount, UUID> {
}
