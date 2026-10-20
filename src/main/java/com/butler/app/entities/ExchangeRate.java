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
@Table(name = "exchange_rates")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "from_currency", nullable = false)
    private String fromCurrency;

    @Column(name = "rate", nullable = false)
    private BigDecimal rate;

    @Column(name = "to_currency", nullable = false)
    private String toCurrency;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
