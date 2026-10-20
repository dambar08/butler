package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "enable_banking_items")
public class EnableBankingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "application_id")
    private String applicationId;

    @Column(name = "aspsp_auth_approach")
    private String aspspAuthApproach;

    @Column(name = "aspsp_id")
    private String aspspId;

    @Column(name = "aspsp_maximum_consent_validity")
    private Integer aspspMaximumConsentValidity;

    @Column(name = "aspsp_name")
    private String aspspName;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "aspsp_psu_types")
    private JsonNode aspspPsuTypes;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "aspsp_required_psu_headers")
    private JsonNode aspspRequiredPsuHeaders;

    @Column(name = "authorization_id")
    private String authorizationId;

    @Column(name = "client_certificate")
    private String clientCertificate;

    @Column(name = "country_code")
    private String countryCode;

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

    @Column(name = "last_psu_ip")
    private String lastPsuIp;

    @Column(name = "name")
    private String name;

    @Column(name = "pending_account_setup")
    private Boolean pendingAccountSetup;

    @Column(name = "psu_type")
    private String psuType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_institution_payload")
    private JsonNode rawInstitutionPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @Column(name = "requested_consent_valid_until")
    private LocalDateTime requestedConsentValidUntil;

    @Column(name = "scheduled_for_deletion")
    private Boolean scheduledForDeletion;

    @Column(name = "session_expires_at")
    private LocalDateTime sessionExpiresAt;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "status")
    private String status;

    @Column(name = "sync_start_date")
    private LocalDate syncStartDate;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
