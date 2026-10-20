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
@Table(name = "plaid_items")
public class PlaidItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "available_products")
    private String availableProducts;

    @Column(name = "billed_products")
    private String billedProducts;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "institution_color")
    private String institutionColor;

    @Column(name = "institution_id")
    private String institutionId;

    @Column(name = "institution_url")
    private String institutionUrl;

    @Column(name = "name")
    private String name;

    @Column(name = "next_cursor")
    private String nextCursor;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "owner_id", nullable = true)
    private User owner;

    @Column(name = "plaid_id", nullable = false)
    private String plaidId;

    @Column(name = "plaid_region", nullable = false)
    private String plaidRegion;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_institution_payload")
    private JsonNode rawInstitutionPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @Column(name = "scheduled_for_deletion")
    private Boolean scheduledForDeletion;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
