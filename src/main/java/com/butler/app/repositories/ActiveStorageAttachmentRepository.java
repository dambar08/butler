package com.butler.app.repositories;

import com.butler.app.entities.ActiveStorageAttachment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveStorageAttachmentRepository extends JpaRepository<ActiveStorageAttachment, UUID> {
}
