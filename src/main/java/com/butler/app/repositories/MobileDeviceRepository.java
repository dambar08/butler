package com.butler.app.repositories;

import com.butler.app.entities.MobileDevice;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileDeviceRepository extends JpaRepository<MobileDevice, UUID> {
}
