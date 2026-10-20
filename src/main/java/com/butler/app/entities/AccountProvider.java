package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "account_providers")
public class AccountProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "provider_id", nullable = false)
    private UUID providerId;

    @Column(name = "provider_type", nullable = false)
    private String providerType;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
