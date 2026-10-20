package com.butler.app.repositories;

import com.butler.app.entities.OidcIdentity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OidcIdentityRepository extends JpaRepository<OidcIdentity, UUID> {
}
