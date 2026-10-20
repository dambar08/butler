package com.butler.app.repositories;

import com.butler.app.entities.EvalResult;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvalResultRepository extends JpaRepository<EvalResult, UUID> {
}
