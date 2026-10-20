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
@Table(name = "coinspot_items")
public class CoinspotItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "api_key")
    private String apiKey;

    @Column(name = "api_secret")
    private String apiSecret;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "institution_color")
    private String institutionColor;

    @Column(name = "institution_domain")
    private String institutionDomain;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "institution_url")
    private String institutionUrl;

    @Column(name = "last_nonce", nullable = false)
    private Long lastNonce;

    @Column(name = "name")
    private String name;

    @Column(name = "pending_account_setup", nullable = false)
    private Boolean pendingAccountSetup;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @Column(name = "scheduled_for_deletion", nullable = false)
    private Boolean scheduledForDeletion;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "sync_start_date")
    private LocalDateTime syncStartDate;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
