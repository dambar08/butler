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
@Table(name = "eval_results")
public class EvalResult {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "actual_output", nullable = false)
    private JsonNode actualOutput;

    @Column(name = "alternative_match")
    private Boolean alternativeMatch;

    @Column(name = "completion_tokens")
    private Integer completionTokens;

    @Column(name = "correct", nullable = false)
    private Boolean correct;

    @Column(name = "cost", precision = 10, scale = 6)
    private BigDecimal cost;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "eval_run_id", nullable = false)
    private EvalRun evalRun;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "eval_sample_id", nullable = false)
    private EvalSample evalSample;

    @Column(name = "exact_match")
    private Boolean exactMatch;

    @Column(name = "fuzzy_score")
    private Double fuzzyScore;

    @Column(name = "hierarchical_match")
    private Boolean hierarchicalMatch;

    @Column(name = "latency_ms")
    private Integer latencyMs;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata")
    private JsonNode metadata;

    @Column(name = "null_expected")
    private Boolean nullExpected;

    @Column(name = "null_returned")
    private Boolean nullReturned;

    @Column(name = "prompt_tokens")
    private Integer promptTokens;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
