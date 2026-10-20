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
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "account_providers_count", nullable = false)
    private Integer accountProvidersCount;

    @Column(name = "accountable_id")
    private UUID accountableId;

    @Column(name = "accountable_type")
    private String accountableType;

    @Column(name = "balance", precision = 19, scale = 4)
    private BigDecimal balance;

    @Column(name = "cash_balance", precision = 19, scale = 4)
    private BigDecimal cashBalance;

    @Column(name = "classification", insertable = false, updatable = false)
    private String classification;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "disabled_at")
    private LocalDateTime disabledAt;

    @Column(name = "enable_category_matcher", nullable = false)
    private Boolean enableCategoryMatcher;

    @Column(name = "exclude_from_reports", nullable = false)
    private Boolean excludeFromReports;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "import_id", nullable = true)
    private Import importValue;

    @Column(name = "institution_domain")
    private String institutionDomain;

    @Column(name = "institution_name")
    private String institutionName;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "locked_attributes")
    private JsonNode lockedAttributes;

    @Column(name = "name")
    private String name;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "owner_id", nullable = true)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "plaid_account_id", nullable = true)
    private PlaidAccount plaidAccount;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "simplefin_account_id", nullable = true)
    private SimplefinAccount simplefinAccount;

    @Column(name = "status")
    private String status;

    @Column(name = "subtype")
    private String subtype;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
