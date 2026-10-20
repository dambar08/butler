package com.butler.app.repositories;

import com.butler.app.entities.NotificationDelivery;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationDeliveryRepository extends JpaRepository<NotificationDelivery, UUID> {
}
