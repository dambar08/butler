package com.butler.app.repositories;

import com.butler.app.entities.Tagging;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaggingRepository extends JpaRepository<Tagging, UUID> {
}
