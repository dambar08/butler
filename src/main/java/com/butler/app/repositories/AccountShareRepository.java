package com.butler.app.repositories;

import com.butler.app.entities.AccountShare;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountShareRepository extends JpaRepository<AccountShare, UUID> {
}
