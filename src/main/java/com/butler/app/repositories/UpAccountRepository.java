package com.butler.app.repositories;

import com.butler.app.entities.UpAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpAccountRepository extends JpaRepository<UpAccount, UUID> {
}
