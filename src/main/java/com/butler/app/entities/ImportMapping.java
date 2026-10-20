package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "import_mappings")
public class ImportMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "create_when_empty")
    private Boolean createWhenEmpty;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "import_id", nullable = false)
    private UUID importId;

    @Column(name = "key")
    private String key;

    @Column(name = "mappable_id")
    private UUID mappableId;

    @Column(name = "mappable_type")
    private String mappableType;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "value")
    private String value;
}
