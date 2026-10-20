package com.butler.app.repositories;

import com.butler.app.entities.PushSubscription;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PushSubscriptionRepository extends JpaRepository<PushSubscription, UUID> {
}
