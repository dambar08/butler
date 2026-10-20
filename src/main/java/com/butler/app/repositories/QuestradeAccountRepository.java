package com.butler.app.repositories;

import com.butler.app.entities.QuestradeAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestradeAccountRepository extends JpaRepository<QuestradeAccount, UUID> {
}
