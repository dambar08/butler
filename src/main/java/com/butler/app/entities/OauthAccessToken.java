package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "oauth_access_tokens")
public class OauthAccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private OauthApplication application;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "expires_in")
    private Integer expiresIn;

    @Column(name = "mobile_device_id")
    private UUID mobileDeviceId;

    @Column(name = "previous_refresh_token", nullable = false)
    private String previousRefreshToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "resource_owner_id")
    private String resourceOwnerId;

    @Column(name = "revoked_at")
    private LocalDateTime revokedAt;

    @Column(name = "scopes")
    private String scopes;

    @Column(name = "token", nullable = false)
    private String token;
}
