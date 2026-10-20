package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "recurring_price_changes")
public class RecurringPriceChange {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "effective_on", nullable = false)
    private LocalDate effectiveOn;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "entry_id", nullable = true)
    private Entry entry;

    @Column(name = "new_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal newAmount;

    @Column(name = "previous_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal previousAmount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recurring_transaction_id", nullable = false)
    private RecurringTransaction recurringTransaction;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
