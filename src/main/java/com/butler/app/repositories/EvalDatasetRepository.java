package com.butler.app.repositories;

import com.butler.app.entities.EvalDataset;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvalDatasetRepository extends JpaRepository<EvalDataset, UUID> {
}
