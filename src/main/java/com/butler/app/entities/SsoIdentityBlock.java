package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "sso_identity_blocks")
public class SsoIdentityBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "identity_label", nullable = false)
    private String identityLabel;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "uid_digest", nullable = false)
    private String uidDigest;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
