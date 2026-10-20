package com.butler.app.repositories;

import com.butler.app.entities.CoinbaseAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinbaseAccountRepository extends JpaRepository<CoinbaseAccount, UUID> {
}
