package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "classification_unused", nullable = false)
    private String classificationUnused;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "last_used_at")
    private LocalDateTime lastUsedAt;

    @Column(name = "lucide_icon", nullable = false)
    private String lucideIcon;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "parent_id")
    private UUID parentId;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
