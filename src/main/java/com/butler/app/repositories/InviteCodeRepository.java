package com.butler.app.repositories;

import com.butler.app.entities.InviteCode;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteCodeRepository extends JpaRepository<InviteCode, UUID> {
}
