package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "oauth_applications")
public class OauthApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "confidential", nullable = false)
    private Boolean confidential;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "owner_id")
    private UUID ownerId;

    @Column(name = "owner_type")
    private String ownerType;

    @Column(name = "redirect_uri", nullable = false)
    private String redirectUri;

    @Column(name = "scopes", nullable = false)
    private String scopes;

    @Column(name = "secret", nullable = false)
    private String secret;

    @Column(name = "uid", nullable = false)
    private String uid;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
