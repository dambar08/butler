package com.butler.app.repositories;

import com.butler.app.entities.TradeRepublicAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepublicAccountRepository extends JpaRepository<TradeRepublicAccount, UUID> {
}
