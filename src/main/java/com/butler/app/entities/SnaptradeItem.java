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
@Table(name = "snaptrade_items")
public class SnaptradeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "consumer_key")
    private String consumerKey;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "institution_color")
    private String institutionColor;

    @Column(name = "institution_domain")
    private String institutionDomain;

    @Column(name = "institution_id")
    private String institutionId;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "institution_url")
    private String institutionUrl;

    @Column(name = "last_synced_at")
    private LocalDateTime lastSyncedAt;

    @Column(name = "name")
    private String name;

    @Column(name = "oauth_access_token")
    private String oauthAccessToken;

    @Column(name = "oauth_refresh_token")
    private String oauthRefreshToken;

    @Column(name = "oauth_scope")
    private String oauthScope;

    @Column(name = "oauth_token_expires_at")
    private LocalDateTime oauthTokenExpiresAt;

    @Column(name = "oauth_token_type")
    private String oauthTokenType;

    @Column(name = "pending_account_setup")
    private Boolean pendingAccountSetup;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_institution_payload")
    private JsonNode rawInstitutionPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @Column(name = "scheduled_for_deletion")
    private Boolean scheduledForDeletion;

    @Column(name = "snaptrade_user_id")
    private String snaptradeUserId;

    @Column(name = "snaptrade_user_secret")
    private String snaptradeUserSecret;

    @Column(name = "status")
    private String status;

    @Column(name = "sync_start_date")
    private LocalDateTime syncStartDate;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
