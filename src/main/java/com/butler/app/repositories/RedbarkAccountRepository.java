package com.butler.app.repositories;

import com.butler.app.entities.RedbarkAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedbarkAccountRepository extends JpaRepository<RedbarkAccount, UUID> {
}
