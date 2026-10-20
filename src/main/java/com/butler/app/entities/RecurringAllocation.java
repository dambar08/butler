package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "recurring_allocations")
public class RecurringAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "allocated_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal allocatedAmount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "entry_id", nullable = true)
    private Entry entry;

    @Column(name = "match_confidence", precision = 5, scale = 4)
    private BigDecimal matchConfidence;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "match_signals", nullable = false)
    private JsonNode matchSignals;

    @Column(name = "paid_on")
    private LocalDate paidOn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recurring_occurrence_id", nullable = false)
    private RecurringOccurrence recurringOccurrence;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "source_amount", precision = 19, scale = 4)
    private BigDecimal sourceAmount;

    @Column(name = "source_currency")
    private String sourceCurrency;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
