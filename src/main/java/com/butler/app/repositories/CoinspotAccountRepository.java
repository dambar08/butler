package com.butler.app.repositories;

import com.butler.app.entities.CoinspotAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinspotAccountRepository extends JpaRepository<CoinspotAccount, UUID> {
}
