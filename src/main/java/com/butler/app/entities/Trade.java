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
@Table(name = "trades")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "extra", nullable = false)
    private JsonNode extra;

    @Column(name = "fee", nullable = false, precision = 19, scale = 4)
    private BigDecimal fee;

    @Column(name = "investment_activity_label")
    private String investmentActivityLabel;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "locked_attributes")
    private JsonNode lockedAttributes;

    @Column(name = "price", precision = 19, scale = 10)
    private BigDecimal price;

    @Column(name = "qty", precision = 34, scale = 18)
    private BigDecimal qty;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
