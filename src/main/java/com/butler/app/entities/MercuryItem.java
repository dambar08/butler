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
@Table(name = "mercury_items")
public class MercuryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "base_url")
    private String baseUrl;

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

    @Column(name = "name")
    private String name;

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

    @Column(name = "status")
    private String status;

    @Column(name = "sync_start_date")
    private LocalDateTime syncStartDate;

    @Column(name = "token")
    private String token;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
