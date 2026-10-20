package com.butler.app.repositories;

import com.butler.app.entities.EvalRun;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvalRunRepository extends JpaRepository<EvalRun, UUID> {
}
