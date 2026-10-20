package com.butler.app.repositories;

import com.butler.app.entities.WebauthnCredential;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebauthnCredentialRepository extends JpaRepository<WebauthnCredential, UUID> {
}
