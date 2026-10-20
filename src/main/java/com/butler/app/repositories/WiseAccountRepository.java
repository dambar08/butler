package com.butler.app.repositories;

import com.butler.app.entities.WiseAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WiseAccountRepository extends JpaRepository<WiseAccount, UUID> {
}
