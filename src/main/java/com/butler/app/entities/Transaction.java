package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "external_id")
    private String externalId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "extra", nullable = false)
    private JsonNode extra;

    @Column(name = "investment_activity_label")
    private String investmentActivityLabel;

    @Column(name = "kind", nullable = false)
    private String kind;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "locked_attributes")
    private JsonNode lockedAttributes;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "merchant_id", nullable = true)
    private Merchant merchant;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "transfer_id", nullable = true)
    private Transfer transfer;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
