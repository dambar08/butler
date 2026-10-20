package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "financekit_accounts")
public class FinancekitAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "accountable_type", nullable = false)
    private String accountableType;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "financekit_account_lineage_id", nullable = false)
    private FinancekitAccountLineage financekitAccountLineage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "financekit_item_id", nullable = false)
    private FinancekitItem financekitItem;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "ledger_timezone", nullable = false)
    private String ledgerTimezone;

    @Column(name = "mapping_digest", nullable = false)
    private String mappingDigest;

    @Column(name = "mapping_version", nullable = false)
    private Integer mappingVersion;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "source_id", nullable = false)
    private UUID sourceId;

    @Column(name = "subtype", nullable = false)
    private String subtype;

    @Column(name = "unavailable_at")
    private LocalDateTime unavailableAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
