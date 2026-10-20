package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "merchants")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "color")
    private String color;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "family_id", nullable = true)
    private Family family;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "provider_merchant_id")
    private String providerMerchantId;

    @Column(name = "source")
    private String source;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "website_url")
    private String websiteUrl;
}
