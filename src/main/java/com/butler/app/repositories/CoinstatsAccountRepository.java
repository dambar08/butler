package com.butler.app.repositories;

import com.butler.app.entities.CoinstatsAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinstatsAccountRepository extends JpaRepository<CoinstatsAccount, UUID> {
}
