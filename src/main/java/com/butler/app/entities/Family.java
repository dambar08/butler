package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "families")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "ai_prompt_overrides", nullable = false)
    private JsonNode aiPromptOverrides;

    @Column(name = "assistant_type", nullable = false)
    private String assistantType;

    @Column(name = "auto_sync_on_login", nullable = false)
    private Boolean autoSyncOnLogin;

    @Column(name = "bills_feed_token")
    private String billsFeedToken;

    @Column(name = "categorization_confidence_threshold", nullable = false, precision = 3, scale = 2)
    private BigDecimal categorizationConfidenceThreshold;

    @Column(name = "categorization_provider", nullable = false)
    private String categorizationProvider;

    @Column(name = "categorization_shadow_rate", nullable = false, precision = 3, scale = 2)
    private BigDecimal categorizationShadowRate;

    @Column(name = "country")
    private String country;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "data_enrichment_enabled")
    private Boolean dataEnrichmentEnabled;

    @Column(name = "date_format")
    private String dateFormat;

    @Column(name = "default_account_sharing", nullable = false)
    private String defaultAccountSharing;

    @Column(name = "early_access")
    private Boolean earlyAccess;

    @Column(name = "enabled_currencies")
    private String enabledCurrencies;

    @Column(name = "household_budget_enabled", nullable = false)
    private Boolean householdBudgetEnabled;

    @Column(name = "last_sync_all_attempted_at")
    private LocalDateTime lastSyncAllAttemptedAt;

    @Column(name = "latest_sync_activity_at")
    private LocalDateTime latestSyncActivityAt;

    @Column(name = "latest_sync_completed_at")
    private LocalDateTime latestSyncCompletedAt;

    @Column(name = "locale")
    private String locale;

    @Column(name = "moniker", nullable = false)
    private String moniker;

    @Column(name = "month_start_day", nullable = false)
    private Integer monthStartDay;

    @Column(name = "name")
    private String name;

    @Column(name = "personal_budgets", nullable = false)
    private Boolean personalBudgets;

    @Column(name = "recurring_transactions_disabled", nullable = false)
    private Boolean recurringTransactionsDisabled;

    @Column(name = "stripe_customer_id")
    private String stripeCustomerId;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "vector_store_id")
    private String vectorStoreId;
}
