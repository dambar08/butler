package com.butler.app.repositories;

import com.butler.app.entities.Import;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportRepository extends JpaRepository<Import, UUID> {
}
