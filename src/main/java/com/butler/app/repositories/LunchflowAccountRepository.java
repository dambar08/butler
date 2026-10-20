package com.butler.app.repositories;

import com.butler.app.entities.LunchflowAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LunchflowAccountRepository extends JpaRepository<LunchflowAccount, UUID> {
}
