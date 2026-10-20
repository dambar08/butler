package com.butler.app.repositories;

import com.butler.app.entities.Property;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, UUID> {
}
