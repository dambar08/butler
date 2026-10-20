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
@Table(name = "holdings")
public class Holding {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "account_provider_id", nullable = true)
    private AccountProvider accountProvider;

    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(name = "cost_basis", precision = 19, scale = 4)
    private BigDecimal costBasis;

    @Column(name = "cost_basis_locked", nullable = false)
    private Boolean costBasisLocked;

    @Column(name = "cost_basis_source")
    private String costBasisSource;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "price", nullable = false, precision = 19, scale = 4)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "provider_security_id", nullable = true)
    private Security providerSecurity;

    @Column(name = "qty", nullable = false, precision = 34, scale = 18)
    private BigDecimal qty;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    @Column(name = "security_locked", nullable = false)
    private Boolean securityLocked;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
