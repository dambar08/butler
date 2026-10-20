package com.butler.app.repositories;

import com.butler.app.entities.ImportSession;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportSessionRepository extends JpaRepository<ImportSession, UUID> {
}
