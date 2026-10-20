package com.butler.app.repositories;

import com.butler.app.entities.SsoProvider;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SsoProviderRepository extends JpaRepository<SsoProvider, UUID> {
}
