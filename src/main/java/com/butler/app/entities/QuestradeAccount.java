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
@Table(name = "questrade_accounts")
public class QuestradeAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "account_status")
    private String accountStatus;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "activities_fetch_pending")
    private Boolean activitiesFetchPending;

    @Column(name = "cash_balance", precision = 19, scale = 4)
    private BigDecimal cashBalance;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "current_balance", precision = 19, scale = 4)
    private BigDecimal currentBalance;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "institution_metadata")
    private JsonNode institutionMetadata;

    @Column(name = "last_activities_sync")
    private LocalDateTime lastActivitiesSync;

    @Column(name = "last_holdings_sync")
    private LocalDateTime lastHoldingsSync;

    @Column(name = "name")
    private String name;

    @Column(name = "provider")
    private String provider;

    @Column(name = "questrade_account_id")
    private String questradeAccountId;

    @Column(name = "questrade_authorization_id")
    private String questradeAuthorizationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "questrade_item_id", nullable = false)
    private QuestradeItem questradeItem;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_activities_payload")
    private JsonNode rawActivitiesPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_balances_payload")
    private JsonNode rawBalancesPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_holdings_payload")
    private JsonNode rawHoldingsPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @Column(name = "sync_start_date")
    private LocalDate syncStartDate;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
