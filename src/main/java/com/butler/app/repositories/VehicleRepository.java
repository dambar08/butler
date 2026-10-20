package com.butler.app.repositories;

import com.butler.app.entities.Vehicle;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
}
