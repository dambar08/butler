package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "provider_request_counts")
public class ProviderRequestCount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "count", nullable = false)
    private Integer count;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "period", nullable = false)
    private String period;

    @Column(name = "provider_key", nullable = false)
    private String providerKey;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
