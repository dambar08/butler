package com.butler.app.repositories;

import com.butler.app.entities.ProviderRequestCount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRequestCountRepository extends JpaRepository<ProviderRequestCount, UUID> {
}
