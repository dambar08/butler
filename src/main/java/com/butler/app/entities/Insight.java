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
@Table(name = "insights")
public class Insight {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "dedup_key", nullable = false)
    private String dedupKey;

    @Column(name = "dismissed_at")
    private LocalDateTime dismissedAt;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "facts", nullable = false)
    private JsonNode facts;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "generated_at", nullable = false)
    private LocalDateTime generatedAt;

    @Column(name = "insight_type", nullable = false)
    private String insightType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata", nullable = false)
    private JsonNode metadata;

    @Column(name = "period_end")
    private LocalDate periodEnd;

    @Column(name = "period_start")
    private LocalDate periodStart;

    @Column(name = "priority", nullable = false)
    private String priority;

    @Column(name = "read_at")
    private LocalDateTime readAt;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
