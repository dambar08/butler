package com.butler.app.repositories;

import com.butler.app.entities.LlmUsage;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LlmUsageRepository extends JpaRepository<LlmUsage, UUID> {
}
