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
@Table(name = "ibkr_accounts")
public class IbkrAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "cash_balance", precision = 19, scale = 4)
    private BigDecimal cashBalance;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "current_balance", precision = 19, scale = 4)
    private BigDecimal currentBalance;

    @Column(name = "ibkr_account_id")
    private String ibkrAccountId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ibkr_item_id", nullable = false)
    private IbkrItem ibkrItem;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "institution_metadata")
    private JsonNode institutionMetadata;

    @Column(name = "last_activities_sync")
    private LocalDateTime lastActivitiesSync;

    @Column(name = "last_holdings_sync")
    private LocalDateTime lastHoldingsSync;

    @Column(name = "name")
    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_activities_payload")
    private JsonNode rawActivitiesPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_cash_report_payload")
    private JsonNode rawCashReportPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_equity_summary_payload", nullable = false)
    private JsonNode rawEquitySummaryPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_holdings_payload")
    private JsonNode rawHoldingsPayload;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
