package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "balances")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "balance", nullable = false, precision = 19, scale = 4)
    private BigDecimal balance;

    @Column(name = "cash_adjustments", nullable = false, precision = 19, scale = 4)
    private BigDecimal cashAdjustments;

    @Column(name = "cash_balance", precision = 19, scale = 4)
    private BigDecimal cashBalance;

    @Column(name = "cash_inflows", nullable = false, precision = 19, scale = 4)
    private BigDecimal cashInflows;

    @Column(name = "cash_outflows", nullable = false, precision = 19, scale = 4)
    private BigDecimal cashOutflows;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "end_balance", precision = 19, scale = 4, insertable = false, updatable = false)
    private BigDecimal endBalance;

    @Column(name = "end_cash_balance", precision = 19, scale = 4, insertable = false, updatable = false)
    private BigDecimal endCashBalance;

    @Column(name = "end_non_cash_balance", precision = 19, scale = 4, insertable = false, updatable = false)
    private BigDecimal endNonCashBalance;

    @Column(name = "flows_factor", nullable = false)
    private Integer flowsFactor;

    @Column(name = "net_market_flows", nullable = false, precision = 19, scale = 4)
    private BigDecimal netMarketFlows;

    @Column(name = "non_cash_adjustments", nullable = false, precision = 19, scale = 4)
    private BigDecimal nonCashAdjustments;

    @Column(name = "non_cash_inflows", nullable = false, precision = 19, scale = 4)
    private BigDecimal nonCashInflows;

    @Column(name = "non_cash_outflows", nullable = false, precision = 19, scale = 4)
    private BigDecimal nonCashOutflows;

    @Column(name = "start_balance", precision = 19, scale = 4, insertable = false, updatable = false)
    private BigDecimal startBalance;

    @Column(name = "start_cash_balance", nullable = false, precision = 19, scale = 4)
    private BigDecimal startCashBalance;

    @Column(name = "start_non_cash_balance", nullable = false, precision = 19, scale = 4)
    private BigDecimal startNonCashBalance;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
