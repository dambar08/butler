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
@Table(name = "enable_banking_accounts")
public class EnableBankingAccount {
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

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "credit_limit", precision = 19, scale = 4)
    private BigDecimal creditLimit;

    @Column(name = "currency")
    private String currency;

    @Column(name = "current_balance", precision = 19, scale = 4)
    private BigDecimal currentBalance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "enable_banking_item_id", nullable = false)
    private EnableBankingItem enableBankingItem;

    @Column(name = "iban")
    private String iban;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "identification_hashes")
    private JsonNode identificationHashes;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "institution_metadata")
    private JsonNode institutionMetadata;

    @Column(name = "name")
    private String name;

    @Column(name = "product")
    private String product;

    @Column(name = "provider")
    private String provider;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_transactions_payload")
    private JsonNode rawTransactionsPayload;

    @Column(name = "treat_balance_as_available_credit", nullable = false)
    private Boolean treatBalanceAsAvailableCredit;

    @Column(name = "uid")
    private String uid;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
