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
@Table(name = "trading212_accounts")
public class Trading212Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "cash_balance", precision = 19, scale = 4)
    private BigDecimal cashBalance;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "current_balance", precision = 19, scale = 4)
    private BigDecimal currentBalance;

    @Column(name = "last_orders_sync")
    private LocalDateTime lastOrdersSync;

    @Column(name = "last_positions_sync")
    private LocalDateTime lastPositionsSync;

    @Column(name = "name")
    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_dividends_payload", nullable = false)
    private JsonNode rawDividendsPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_orders_payload", nullable = false)
    private JsonNode rawOrdersPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_positions_payload", nullable = false)
    private JsonNode rawPositionsPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_transactions_payload", nullable = false)
    private JsonNode rawTransactionsPayload;

    @Column(name = "trading212_account_id")
    private String trading212AccountId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trading212_item_id", nullable = false)
    private Trading212Item trading212Item;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
