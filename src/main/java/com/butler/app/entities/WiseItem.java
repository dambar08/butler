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
@Table(name = "wise_items")
public class WiseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "import_all_history", nullable = false)
    private Boolean importAllHistory;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pending_account_setup", nullable = false)
    private Boolean pendingAccountSetup;

    @Column(name = "profile_id", nullable = false)
    private String profileId;

    @Column(name = "profile_type", nullable = false)
    private String profileType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @Column(name = "sca_private_key")
    private String scaPrivateKey;

    @Column(name = "scheduled_for_deletion", nullable = false)
    private Boolean scheduledForDeletion;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "sync_start_date")
    private LocalDateTime syncStartDate;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
