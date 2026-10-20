package com.butler.app.repositories;

import com.butler.app.entities.BinanceAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinanceAccountRepository extends JpaRepository<BinanceAccount, UUID> {
}
