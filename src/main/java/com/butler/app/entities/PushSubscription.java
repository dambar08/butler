package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "push_subscriptions")
public class PushSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "device_key_digest")
    private String deviceKeyDigest;

    @Column(name = "environment", nullable = false)
    private String environment;

    @Column(name = "last_registered_at", nullable = false)
    private LocalDateTime lastRegisteredAt;

    @Column(name = "platform", nullable = false)
    private String platform;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
