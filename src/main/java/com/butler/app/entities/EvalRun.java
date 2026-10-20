package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "eval_runs")
public class EvalRun {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "error_message")
    private String errorMessage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "eval_dataset_id", nullable = false)
    private EvalDataset evalDataset;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metrics")
    private JsonNode metrics;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "name")
    private String name;

    @Column(name = "provider", nullable = false)
    private String provider;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "provider_config")
    private JsonNode providerConfig;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "total_completion_tokens")
    private Integer totalCompletionTokens;

    @Column(name = "total_cost", precision = 10, scale = 6)
    private BigDecimal totalCost;

    @Column(name = "total_prompt_tokens")
    private Integer totalPromptTokens;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
