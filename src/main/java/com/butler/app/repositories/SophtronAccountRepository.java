package com.butler.app.repositories;

import com.butler.app.entities.SophtronAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SophtronAccountRepository extends JpaRepository<SophtronAccount, UUID> {
}
