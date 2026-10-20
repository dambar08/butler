package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "addressable_id")
    private UUID addressableId;

    @Column(name = "addressable_type")
    private String addressableType;

    @Column(name = "country")
    private String country;

    @Column(name = "county")
    private String county;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "locality")
    private String locality;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "region")
    private String region;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
