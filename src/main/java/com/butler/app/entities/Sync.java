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
@Table(name = "syncs")
public class Sync {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "cancel_requested_at")
    private LocalDateTime cancelRequestedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "data")
    private JsonNode data;

    @Column(name = "error")
    private String error;

    @Column(name = "failed_at")
    private LocalDateTime failedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "parent_id", nullable = true)
    private Sync parent;

    @Column(name = "pending_at")
    private LocalDateTime pendingAt;

    @Column(name = "status")
    private String status;

    @Column(name = "sync_stats")
    private String syncStats;

    @Column(name = "syncable_id", nullable = false)
    private UUID syncableId;

    @Column(name = "syncable_type", nullable = false)
    private String syncableType;

    @Column(name = "syncing_at")
    private LocalDateTime syncingAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "window_end_date")
    private LocalDate windowEndDate;

    @Column(name = "window_start_date")
    private LocalDate windowStartDate;
}
