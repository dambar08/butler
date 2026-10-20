package com.butler.app.repositories;

import com.butler.app.entities.FioAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FioAccountRepository extends JpaRepository<FioAccount, UUID> {
}
