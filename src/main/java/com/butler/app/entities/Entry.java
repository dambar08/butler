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
@Table(name = "entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "entryable_id")
    private UUID entryableId;

    @Column(name = "entryable_type")
    private String entryableType;

    @Column(name = "excluded")
    private Boolean excluded;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "idempotency_key")
    private String idempotencyKey;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "import_id", nullable = true)
    private Import importValue;

    @Column(name = "import_locked", nullable = false)
    private Boolean importLocked;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "locked_attributes")
    private JsonNode lockedAttributes;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "parent_entry_id", nullable = true)
    private Entry parentEntry;

    @Column(name = "plaid_id")
    private String plaidId;

    @Column(name = "reconciled_at")
    private LocalDateTime reconciledAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "reconciled_by_statement_id", nullable = true)
    private AccountStatement reconciledByStatement;

    @Column(name = "source")
    private String source;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "user_modified", nullable = false)
    private Boolean userModified;
}
