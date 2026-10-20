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
@Table(name = "security_splits")
public class SecuritySplit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "denominator", nullable = false)
    private Integer denominator;

    @Column(name = "ex_date", nullable = false)
    private LocalDate exDate;

    @Column(name = "numerator", nullable = false)
    private Integer numerator;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
