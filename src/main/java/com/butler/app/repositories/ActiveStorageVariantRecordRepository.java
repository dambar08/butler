package com.butler.app.repositories;

import com.butler.app.entities.ActiveStorageVariantRecord;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveStorageVariantRecordRepository extends JpaRepository<ActiveStorageVariantRecord, UUID> {
}
