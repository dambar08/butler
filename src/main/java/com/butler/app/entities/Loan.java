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
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "down_payment", precision = 19, scale = 4)
    private BigDecimal downPayment;

    @Column(name = "initial_balance", precision = 19, scale = 4)
    private BigDecimal initialBalance;

    @Column(name = "insurance_rate", precision = 8, scale = 4)
    private BigDecimal insuranceRate;

    @Column(name = "insurance_rate_type")
    private String insuranceRateType;

    @Column(name = "interest_rate", precision = 10, scale = 3)
    private BigDecimal interestRate;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "locked_attributes")
    private JsonNode lockedAttributes;

    @Column(name = "rate_type")
    private String rateType;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "subtype")
    private String subtype;

    @Column(name = "term_months")
    private Integer termMonths;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "variable_rate_schedule", nullable = false)
    private JsonNode variableRateSchedule;
}
