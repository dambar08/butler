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
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "color")
    private String color;

    @Column(name = "completed_amount", precision = 19, scale = 4)
    private BigDecimal completedAmount;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "consumed_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal consumedAmount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "icon")
    private String icon;

    @Column(name = "kind", nullable = false)
    private String kind;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "notes")
    private String notes;

    @Column(name = "progress_basis", nullable = false)
    private String progressBasis;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "target_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal targetAmount;

    @Column(name = "target_date")
    private LocalDate targetDate;

    @Column(name = "target_mode", nullable = false)
    private String targetMode;

    @Column(name = "target_months")
    private Integer targetMonths;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
