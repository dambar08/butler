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
@Table(name = "securities")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "asset_class")
    private String assetClass;

    @Column(name = "asset_sub_class")
    private String assetSubClass;

    @Column(name = "classification_locked", nullable = false)
    private Boolean classificationLocked;

    @Column(name = "classification_source")
    private String classificationSource;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "exchange_acronym")
    private String exchangeAcronym;

    @Column(name = "exchange_mic")
    private String exchangeMic;

    @Column(name = "exchange_operating_mic")
    private String exchangeOperatingMic;

    @Column(name = "failed_fetch_at")
    private LocalDateTime failedFetchAt;

    @Column(name = "failed_fetch_count", nullable = false)
    private Integer failedFetchCount;

    @Column(name = "first_provider_price_on")
    private LocalDate firstProviderPriceOn;

    @Column(name = "industry")
    private String industry;

    @Column(name = "kind", nullable = false)
    private String kind;

    @Column(name = "last_health_check_at")
    private LocalDateTime lastHealthCheckAt;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "name")
    private String name;

    @Column(name = "offline", nullable = false)
    private Boolean offline;

    @Column(name = "offline_reason")
    private String offlineReason;

    @Column(name = "price_provider")
    private String priceProvider;

    @Column(name = "region")
    private String region;

    @Column(name = "sector")
    private String sector;

    @Column(name = "ticker", nullable = false)
    private String ticker;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "website_url")
    private String websiteUrl;
}
