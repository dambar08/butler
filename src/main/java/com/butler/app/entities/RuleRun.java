package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "rule_runs")
public class RuleRun {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "executed_at", nullable = false)
    private LocalDateTime executedAt;

    @Column(name = "execution_type", nullable = false)
    private String executionType;

    @Column(name = "pending_jobs_count", nullable = false)
    private Integer pendingJobsCount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rule_id", nullable = false)
    private Rule rule;

    @Column(name = "rule_name")
    private String ruleName;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "transactions_modified", nullable = false)
    private Integer transactionsModified;

    @Column(name = "transactions_processed", nullable = false)
    private Integer transactionsProcessed;

    @Column(name = "transactions_queued", nullable = false)
    private Integer transactionsQueued;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
