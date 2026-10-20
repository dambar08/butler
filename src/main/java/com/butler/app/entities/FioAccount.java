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
@Table(name = "fio_accounts")
public class FioAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "bank_id")
    private String bankId;

    @Column(name = "bic")
    private String bic;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "current_balance", precision = 19, scale = 4)
    private BigDecimal currentBalance;

    @Column(name = "fio_account_id")
    private String fioAccountId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fio_item_id", nullable = false)
    private FioItem fioItem;

    @Column(name = "history_synced_from")
    private LocalDate historySyncedFrom;

    @Column(name = "iban")
    private String iban;

    @Column(name = "ignored", nullable = false)
    private Boolean ignored;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "institution_metadata")
    private JsonNode institutionMetadata;

    @Column(name = "name", nullable = false)
    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_transactions_payload")
    private JsonNode rawTransactionsPayload;

    @Column(name = "sync_start_date")
    private LocalDate syncStartDate;

    @Column(name = "transactions_synced_through")
    private LocalDate transactionsSyncedThrough;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
