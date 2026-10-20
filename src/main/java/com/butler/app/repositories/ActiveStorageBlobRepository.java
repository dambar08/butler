package com.butler.app.repositories;

import com.butler.app.entities.ActiveStorageBlob;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveStorageBlobRepository extends JpaRepository<ActiveStorageBlob, UUID> {
}
