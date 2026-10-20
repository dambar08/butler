package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "budget_categories")
public class BudgetCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "budget_id", nullable = false)
    private Budget budget;

    @Column(name = "budgeted_spending", nullable = false, precision = 19, scale = 4)
    private BigDecimal budgetedSpending;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "rolled_over_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal rolledOverAmount;

    @Column(name = "rollover_enabled", nullable = false)
    private Boolean rolloverEnabled;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
