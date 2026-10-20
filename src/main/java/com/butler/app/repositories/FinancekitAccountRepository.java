package com.butler.app.repositories;

import com.butler.app.entities.FinancekitAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancekitAccountRepository extends JpaRepository<FinancekitAccount, UUID> {
}
