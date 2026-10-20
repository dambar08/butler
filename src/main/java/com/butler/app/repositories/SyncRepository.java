package com.butler.app.repositories;

import com.butler.app.entities.Sync;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyncRepository extends JpaRepository<Sync, UUID> {
}
