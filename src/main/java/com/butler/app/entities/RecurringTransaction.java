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
@Table(name = "recurring_transactions")
public class RecurringTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "account_id", nullable = true)
    private Account account;

    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(name = "amount_strategy", nullable = false)
    private String amountStrategy;

    @Column(name = "amount_tolerance_pct", nullable = false, precision = 5, scale = 2)
    private BigDecimal amountTolerancePct;

    @Column(name = "anchor_date")
    private LocalDate anchorDate;

    @Column(name = "autopay", nullable = false)
    private Boolean autopay;

    @Column(name = "bill_type", nullable = false)
    private String billType;

    @Column(name = "cancelled_on")
    private LocalDate cancelledOn;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "dedup_scope", nullable = false)
    private String dedupScope;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "destination_account_id", nullable = true)
    private Account destinationAccount;

    @Column(name = "end_after_count")
    private Integer endAfterCount;

    @Column(name = "end_mode", nullable = false)
    private String endMode;

    @Column(name = "end_on")
    private LocalDate endOn;

    @Column(name = "expected_amount_avg", precision = 19, scale = 4)
    private BigDecimal expectedAmountAvg;

    @Column(name = "expected_amount_max", precision = 19, scale = 4)
    private BigDecimal expectedAmountMax;

    @Column(name = "expected_amount_min", precision = 19, scale = 4)
    private BigDecimal expectedAmountMin;

    @Column(name = "expected_day_of_month", nullable = false)
    private Integer expectedDayOfMonth;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "holiday_calendar")
    private String holidayCalendar;

    @Column(name = "last_occurrence_date", nullable = false)
    private LocalDate lastOccurrenceDate;

    @Column(name = "manual", nullable = false)
    private Boolean manual;

    @Column(name = "match_days_early", nullable = false)
    private Integer matchDaysEarly;

    @Column(name = "match_days_late", nullable = false)
    private Integer matchDaysLate;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "matcher_hints", nullable = false)
    private JsonNode matcherHints;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "merchant_id", nullable = true)
    private Merchant merchant;

    @Column(name = "name")
    private String name;

    @Column(name = "next_expected_date", nullable = false)
    private LocalDate nextExpectedDate;

    @Column(name = "notes")
    private String notes;

    @Column(name = "notify_days_before")
    private Integer notifyDaysBefore;

    @Column(name = "occurrence_count", nullable = false)
    private Integer occurrenceCount;

    @Column(name = "overdue_grace_days")
    private Integer overdueGraceDays;

    @Column(name = "payment_url")
    private String paymentUrl;

    @Column(name = "renews_on")
    private LocalDate renewsOn;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "replaced_by_id", nullable = true)
    private RecurringTransaction replacedBy;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "trial_ends_on")
    private LocalDate trialEndsOn;

    @Column(name = "upcoming_window_days")
    private Integer upcomingWindowDays;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "weekend_adjust", nullable = false)
    private String weekendAdjust;
}
