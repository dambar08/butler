package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "credit_cards")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "annual_fee", precision = 10, scale = 2)
    private BigDecimal annualFee;

    @Column(name = "apr", precision = 10, scale = 2)
    private BigDecimal apr;

    @Column(name = "available_credit", precision = 10, scale = 2)
    private BigDecimal availableCredit;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "locked_attributes")
    private JsonNode lockedAttributes;

    @Column(name = "minimum_payment", precision = 10, scale = 2)
    private BigDecimal minimumPayment;

    @Column(name = "subtype")
    private String subtype;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
