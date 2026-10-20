package com.butler.app.repositories;

import com.butler.app.entities.AccountProvider;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountProviderRepository extends JpaRepository<AccountProvider, UUID> {
}
