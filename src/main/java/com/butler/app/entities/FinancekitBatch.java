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
@Table(name = "financekit_batches")
public class FinancekitBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "accepted_at", nullable = false)
    private LocalDateTime acceptedAt;

    @Column(name = "applied_at")
    private LocalDateTime appliedAt;

    @Column(name = "attempts", nullable = false)
    private Integer attempts;

    @Column(name = "batch_id", nullable = false)
    private UUID batchId;

    @Column(name = "capture_id", nullable = false)
    private UUID captureId;

    @Column(name = "capture_mode", nullable = false)
    private String captureMode;

    @Column(name = "captured_at", nullable = false)
    private LocalDateTime capturedAt;

    @Column(name = "chunk_count", nullable = false)
    private Integer chunkCount;

    @Column(name = "chunk_index", nullable = false)
    private Integer chunkIndex;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "counts", nullable = false)
    private JsonNode counts;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "downstream_completed_at")
    private LocalDateTime downstreamCompletedAt;

    @Column(name = "error_code")
    private String errorCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "financekit_item_id", nullable = false)
    private FinancekitItem financekitItem;

    @Column(name = "generation", nullable = false)
    private Long generation;

    @Column(name = "payload")
    private byte[] payload;

    @Column(name = "payload_digest", nullable = false)
    private String payloadDigest;

    @Column(name = "predecessor_digest")
    private String predecessorDigest;

    @Column(name = "retry_at")
    private LocalDateTime retryAt;

    @Column(name = "sequence", nullable = false)
    private Long sequence;

    @Column(name = "snapshot_complete", nullable = false)
    private Boolean snapshotComplete;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "stream_id", nullable = false)
    private UUID streamId;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "sync_id", nullable = true)
    private Sync sync;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
