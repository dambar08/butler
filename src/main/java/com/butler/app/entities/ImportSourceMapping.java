package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "import_source_mappings")
public class ImportSourceMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "import_session_id", nullable = false)
    private ImportSession importSession;

    @Column(name = "source_id", nullable = false, length = 255)
    private String sourceId;

    @Column(name = "source_type", nullable = false, length = 64)
    private String sourceType;

    @Column(name = "target_id", nullable = false)
    private UUID targetId;

    @Column(name = "target_type", nullable = false)
    private String targetType;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
