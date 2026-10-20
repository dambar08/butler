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
@Table(name = "financekit_items")
public class FinancekitItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "consent", nullable = false)
    private JsonNode consent;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "credential_digest")
    private String credentialDigest;

    @Column(name = "enrollment_digest", nullable = false)
    private String enrollmentDigest;

    @Column(name = "enrollment_id", nullable = false)
    private UUID enrollmentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "generation", nullable = false)
    private Long generation;

    @Column(name = "last_accepted_at")
    private LocalDateTime lastAcceptedAt;

    @Column(name = "last_captured_at")
    private LocalDateTime lastCapturedAt;

    @Column(name = "last_device_contact_at")
    private LocalDateTime lastDeviceContactAt;

    @Column(name = "last_downstream_at")
    private LocalDateTime lastDownstreamAt;

    @Column(name = "last_imported_at")
    private LocalDateTime lastImportedAt;

    @Column(name = "next_sequence", nullable = false)
    private Long nextSequence;

    @Column(name = "predecessor_digest")
    private String predecessorDigest;

    @Column(name = "publisher_id", nullable = false)
    private UUID publisherId;

    @Column(name = "purge_completed_at")
    private LocalDateTime purgeCompletedAt;

    @Column(name = "purge_requested_at")
    private LocalDateTime purgeRequestedAt;

    @Column(name = "repair_reason")
    private String repairReason;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "replaces_financekit_item_id", nullable = true)
    private FinancekitItem replacesFinancekitItem;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "stream_id")
    private UUID streamId;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
