package com.butler.app.repositories;

import com.butler.app.entities.ImpersonationSessionLog;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpersonationSessionLogRepository extends JpaRepository<ImpersonationSessionLog, UUID> {
}
