package com.butler.app.repositories;

import com.butler.app.entities.Invitation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface InvitationRepository extends JpaRepository<Invitation, UUID> {
    @Transactional
    long deleteAllByFamily_Id(UUID familyId);
}
