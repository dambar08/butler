package com.butler.app.repositories;

import com.butler.app.entities.IndexaCapitalAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndexaCapitalAccountRepository extends JpaRepository<IndexaCapitalAccount, UUID> {
}
