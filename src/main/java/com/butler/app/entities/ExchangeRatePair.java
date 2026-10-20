package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "exchange_rate_pairs")
public class ExchangeRatePair {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "first_provider_rate_on")
    private LocalDate firstProviderRateOn;

    @Column(name = "from_currency", nullable = false)
    private String fromCurrency;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "to_currency", nullable = false)
    private String toCurrency;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
