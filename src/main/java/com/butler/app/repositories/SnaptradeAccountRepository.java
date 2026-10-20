package com.butler.app.repositories;

import com.butler.app.entities.SnaptradeAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnaptradeAccountRepository extends JpaRepository<SnaptradeAccount, UUID> {
}
