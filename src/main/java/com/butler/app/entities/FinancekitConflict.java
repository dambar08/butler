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
@Table(name = "financekit_conflicts")
public class FinancekitConflict {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "details", nullable = false)
    private JsonNode details;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "financekit_account_lineage_id", nullable = true)
    private FinancekitAccountLineage financekitAccountLineage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "financekit_item_id", nullable = false)
    private FinancekitItem financekitItem;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "financekit_transaction_id", nullable = true)
    private FinancekitTransaction financekitTransaction;

    @Column(name = "kind", nullable = false)
    private String kind;

    @Column(name = "resolution")
    private String resolution;

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "resolved_by_id", nullable = true)
    private User resolvedBy;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
