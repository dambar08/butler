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
@Table(name = "plaid_accounts")
public class PlaidAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "available_balance", precision = 19, scale = 4)
    private BigDecimal availableBalance;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "current_balance", precision = 19, scale = 4)
    private BigDecimal currentBalance;

    @Column(name = "mask")
    private String mask;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "plaid_id", nullable = false)
    private String plaidId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plaid_item_id", nullable = false)
    private PlaidItem plaidItem;

    @Column(name = "plaid_subtype")
    private String plaidSubtype;

    @Column(name = "plaid_type", nullable = false)
    private String plaidType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_holdings_payload")
    private JsonNode rawHoldingsPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_liabilities_payload")
    private JsonNode rawLiabilitiesPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_transactions_payload")
    private JsonNode rawTransactionsPayload;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
