package com.butler.app.repositories;

import com.butler.app.entities.BrexAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrexAccountRepository extends JpaRepository<BrexAccount, UUID> {
}
