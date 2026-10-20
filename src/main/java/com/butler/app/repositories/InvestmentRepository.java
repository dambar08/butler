package com.butler.app.repositories;

import com.butler.app.entities.Investment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, UUID> {
}
