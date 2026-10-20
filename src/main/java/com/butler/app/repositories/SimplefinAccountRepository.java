package com.butler.app.repositories;

import com.butler.app.entities.SimplefinAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimplefinAccountRepository extends JpaRepository<SimplefinAccount, UUID> {
}
