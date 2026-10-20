package com.butler.app.repositories;

import com.butler.app.entities.ImportRow;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportRowRepository extends JpaRepository<ImportRow, UUID> {
}
