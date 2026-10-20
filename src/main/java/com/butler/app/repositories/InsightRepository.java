package com.butler.app.repositories;

import com.butler.app.entities.Insight;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsightRepository extends JpaRepository<Insight, UUID> {
}
