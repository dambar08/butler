package com.butler.app.repositories;

import com.butler.app.entities.SsoAuditLog;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SsoAuditLogRepository extends JpaRepository<SsoAuditLog, UUID> {
}
