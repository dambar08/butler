package com.butler.app.repositories;

import com.butler.app.entities.ImpersonationSession;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpersonationSessionRepository extends JpaRepository<ImpersonationSession, UUID> {
}
