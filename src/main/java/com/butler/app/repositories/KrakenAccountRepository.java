package com.butler.app.repositories;

import com.butler.app.entities.KrakenAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KrakenAccountRepository extends JpaRepository<KrakenAccount, UUID> {
}
