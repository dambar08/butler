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
@Table(name = "akahu_accounts")
public class AkahuAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "account_status")
    private String accountStatus;

    @Column(name = "account_type")
    private String accountType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "akahu_item_id", nullable = false)
    private AkahuItem akahuItem;

    @Column(name = "available_balance", precision = 19, scale = 4)
    private BigDecimal availableBalance;

    @Column(name = "balance_limit", precision = 19, scale = 4)
    private BigDecimal balanceLimit;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "current_balance", precision = 19, scale = 4)
    private BigDecimal currentBalance;

    @Column(name = "formatted_account")
    private String formattedAccount;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "institution_metadata")
    private JsonNode institutionMetadata;

    @Column(name = "name")
    private String name;

    @Column(name = "provider")
    private String provider;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_transactions_payload")
    private JsonNode rawTransactionsPayload;

    @Column(name = "sync_start_date")
    private LocalDate syncStartDate;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
