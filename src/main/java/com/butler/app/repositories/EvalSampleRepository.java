package com.butler.app.repositories;

import com.butler.app.entities.EvalSample;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvalSampleRepository extends JpaRepository<EvalSample, UUID> {
}
