package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "active_storage_blobs")
public class ActiveStorageBlob {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "byte_size", nullable = false)
    private Long byteSize;

    @Column(name = "checksum")
    private String checksum;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "key", nullable = false)
    private String key;

    @Column(name = "metadata")
    private String metadata;

    @Column(name = "service_name", nullable = false)
    private String serviceName;
}
