package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "sso_providers")
public class SsoProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "icon")
    private String icon;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "redirect_uri")
    private String redirectUri;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "settings", nullable = false)
    private JsonNode settings;

    @Column(name = "strategy", nullable = false)
    private String strategy;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
