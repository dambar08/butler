package com.butler.app.repositories;

import com.butler.app.entities.Family;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, UUID> {
}
