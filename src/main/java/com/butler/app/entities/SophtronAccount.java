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
@Table(name = "sophtron_accounts")
public class SophtronAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "account_number_mask")
    private String accountNumberMask;

    @Column(name = "account_status")
    private String accountStatus;

    @Column(name = "account_sub_type")
    private String accountSubType;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "available_balance", precision = 19, scale = 4)
    private BigDecimal availableBalance;

    @Column(name = "balance", precision = 19, scale = 4)
    private BigDecimal balance;

    @Column(name = "balance_sign_override")
    private String balanceSignOverride;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "customer_id")
    private String customerId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "institution_metadata")
    private JsonNode institutionMetadata;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @Column(name = "manual_sync", nullable = false)
    private Boolean manualSync;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "name", nullable = false)
    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_transactions_payload")
    private JsonNode rawTransactionsPayload;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sophtron_item_id", nullable = false)
    private SophtronItem sophtronItem;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
