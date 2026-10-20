package com.butler.app.repositories;

import com.butler.app.entities.Session;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, UUID> {
}
