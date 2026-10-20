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
@Table(name = "indexa_capital_accounts")
public class IndexaCapitalAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "account_number")
    private String accountNumber;

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

    @Column(name = "indexa_capital_account_id")
    private String indexaCapitalAccountId;

    @Column(name = "indexa_capital_authorization_id")
    private String indexaCapitalAuthorizationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "indexa_capital_item_id", nullable = false)
    private IndexaCapitalItem indexaCapitalItem;

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

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_activities_payload")
    private JsonNode rawActivitiesPayload;

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
