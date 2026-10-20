package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "import_rows")
public class ImportRow {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "account")
    private String account;

    @Column(name = "actions")
    private String actions;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "amount")
    private String amount;

    @Column(name = "category")
    private String category;

    @Column(name = "category_classification")
    private String categoryClassification;

    @Column(name = "category_color")
    private String categoryColor;

    @Column(name = "category_icon")
    private String categoryIcon;

    @Column(name = "category_parent")
    private String categoryParent;

    @Column(name = "conditions")
    private String conditions;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "date")
    private String date;

    @Column(name = "effective_date")
    private String effectiveDate;

    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "exchange_operating_mic")
    private String exchangeOperatingMic;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "import_id", nullable = false)
    private Import importValue;

    @Column(name = "merchant_color")
    private String merchantColor;

    @Column(name = "merchant_website")
    private String merchantWebsite;

    @Column(name = "name")
    private String name;

    @Column(name = "notes")
    private String notes;

    @Column(name = "price")
    private String price;

    @Column(name = "qty")
    private String qty;

    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "source_row_number", nullable = false)
    private Integer sourceRowNumber;

    @Column(name = "tags")
    private String tags;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
