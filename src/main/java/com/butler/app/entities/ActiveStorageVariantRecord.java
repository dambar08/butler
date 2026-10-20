package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "active_storage_variant_records")
public class ActiveStorageVariantRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "blob_id", nullable = false)
    private ActiveStorageBlob blob;

    @Column(name = "variation_digest", nullable = false)
    private String variationDigest;
}
