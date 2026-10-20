package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "oauth_access_grants")
public class OauthAccessGrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private OauthApplication application;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "expires_in", nullable = false)
    private Integer expiresIn;

    @Column(name = "redirect_uri", nullable = false)
    private String redirectUri;

    @Column(name = "resource_owner_id", nullable = false)
    private String resourceOwnerId;

    @Column(name = "revoked_at")
    private LocalDateTime revokedAt;

    @Column(name = "scopes", nullable = false)
    private String scopes;

    @Column(name = "token", nullable = false)
    private String token;
}
