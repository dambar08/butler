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
@Table(name = "llm_usages")
public class LlmUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "cache_creation_tokens")
    private Integer cacheCreationTokens;

    @Column(name = "cache_read_tokens")
    private Integer cacheReadTokens;

    @Column(name = "completion_tokens", nullable = false)
    private Integer completionTokens;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "estimated_cost", precision = 10, scale = 6)
    private BigDecimal estimatedCost;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata")
    private JsonNode metadata;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "operation", nullable = false)
    private String operation;

    @Column(name = "prompt_tokens", nullable = false)
    private Integer promptTokens;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "total_tokens", nullable = false)
    private Integer totalTokens;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
