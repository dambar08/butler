package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "financekit_balance_observations")
public class FinancekitBalanceObservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "direction", nullable = false)
    private String direction;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "financekit_account_id", nullable = true)
    private FinancekitAccount financekitAccount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "financekit_account_lineage_id", nullable = false)
    private FinancekitAccountLineage financekitAccountLineage;

    @Column(name = "kind", nullable = false)
    private String kind;

    @Column(name = "observed_at", nullable = false)
    private LocalDateTime observedAt;

    @Column(name = "source_id", nullable = false)
    private UUID sourceId;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
