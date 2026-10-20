package com.butler.app.repositories;

import com.butler.app.entities.SsoIdentityBlock;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SsoIdentityBlockRepository extends JpaRepository<SsoIdentityBlock, UUID> {
}
