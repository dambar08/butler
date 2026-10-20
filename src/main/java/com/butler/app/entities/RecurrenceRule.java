package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "recurrence_rules")
public class RecurrenceRule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "day_of_month")
    private Integer dayOfMonth;

    @Column(name = "frequency", nullable = false)
    private String frequency;

    @Column(name = "interval", nullable = false)
    private Integer interval;

    @Column(name = "month_of_year")
    private Integer monthOfYear;

    @Column(name = "position", nullable = false)
    private Integer position;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recurring_transaction_id", nullable = false)
    private RecurringTransaction recurringTransaction;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "weekday")
    private Integer weekday;

    @Column(name = "weekday_ordinal")
    private Integer weekdayOrdinal;
}
