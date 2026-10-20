package com.butler.app.repositories;

import com.butler.app.entities.MercuryAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercuryAccountRepository extends JpaRepository<MercuryAccount, UUID> {
}
