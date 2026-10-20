package com.butler.app.repositories;

import com.butler.app.entities.RejectedTransfer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RejectedTransferRepository extends JpaRepository<RejectedTransfer, UUID> {
}
