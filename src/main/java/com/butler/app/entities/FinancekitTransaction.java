package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "financekit_transactions")
public class FinancekitTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "entry_id", nullable = true)
    private Entry entry;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "financekit_account_id", nullable = true)
    private FinancekitAccount financekitAccount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "financekit_account_lineage_id", nullable = false)
    private FinancekitAccountLineage financekitAccountLineage;

    @Column(name = "generation", nullable = false)
    private Long generation;

    @Column(name = "ledger_imported", nullable = false)
    private Boolean ledgerImported;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @Column(name = "review_required", nullable = false)
    private Boolean reviewRequired;

    @Column(name = "sequence", nullable = false)
    private Long sequence;

    @Column(name = "source_id", nullable = false)
    private UUID sourceId;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "tombstoned_at")
    private LocalDateTime tombstonedAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
