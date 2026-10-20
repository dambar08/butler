package com.butler.app.repositories;

import com.butler.app.entities.DataEnrichment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataEnrichmentRepository extends JpaRepository<DataEnrichment, UUID> {
}
