package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "webauthn_credentials")
public class WebauthnCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "credential_id", nullable = false)
    private String credentialId;

    @Column(name = "last_used_at")
    private LocalDateTime lastUsedAt;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "public_key", nullable = false)
    private String publicKey;

    @Column(name = "sign_count", nullable = false)
    private Long signCount;

    @Column(name = "transports", nullable = false)
    private String transports;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
