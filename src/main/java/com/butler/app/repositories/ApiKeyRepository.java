package com.butler.app.repositories;

import com.butler.app.entities.ApiKey;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
}
