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
@Table(name = "categorization_comparisons")
public class CategorizationComparison {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "agreed", nullable = false)
    private Boolean agreed;

    @Column(name = "applied_category_name")
    private String appliedCategoryName;

    @Column(name = "applied_provider", nullable = false)
    private String appliedProvider;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "shadow_category_name")
    private String shadowCategoryName;

    @Column(name = "shadow_confidence", precision = 5, scale = 4)
    private BigDecimal shadowConfidence;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "shadow_probabilities", nullable = false)
    private JsonNode shadowProbabilities;

    @Column(name = "shadow_provider", nullable = false)
    private String shadowProvider;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "transaction_id", nullable = true)
    private Transaction transaction;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
