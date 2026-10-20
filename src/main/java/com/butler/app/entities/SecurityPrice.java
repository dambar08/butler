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
@Table(name = "security_prices")
public class SecurityPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "price", nullable = false, precision = 19, scale = 4)
    private BigDecimal price;

    @Column(name = "provisional", nullable = false)
    private Boolean provisional;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "security_id", nullable = true)
    private Security security;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
