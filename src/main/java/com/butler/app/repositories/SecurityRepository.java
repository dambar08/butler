package com.butler.app.repositories;

import com.butler.app.entities.Security;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<Security, UUID> {
}
