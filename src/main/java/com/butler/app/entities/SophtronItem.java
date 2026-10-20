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
@Table(name = "sophtron_items")
public class SophtronItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "access_key", nullable = false)
    private String accessKey;

    @Column(name = "base_url")
    private String baseUrl;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "current_job_id")
    private String currentJobId;

    @Column(name = "current_job_sophtron_account_id")
    private UUID currentJobSophtronAccountId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

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

    @Column(name = "job_status")
    private String jobStatus;

    @Column(name = "last_connection_error")
    private String lastConnectionError;

    @Column(name = "manual_sync", nullable = false)
    private Boolean manualSync;

    @Column(name = "name")
    private String name;

    @Column(name = "pending_account_setup")
    private Boolean pendingAccountSetup;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_customer_payload")
    private JsonNode rawCustomerPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_institution_payload")
    private JsonNode rawInstitutionPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_job_payload")
    private JsonNode rawJobPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @Column(name = "scheduled_for_deletion")
    private Boolean scheduledForDeletion;

    @Column(name = "status")
    private String status;

    @Column(name = "sync_start_date")
    private LocalDateTime syncStartDate;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_institution_id")
    private String userInstitutionId;
}
