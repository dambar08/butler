package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "ibkr_items")
public class IbkrItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "name")
    private String name;

    @Column(name = "pending_account_setup", nullable = false)
    private Boolean pendingAccountSetup;

    @Column(name = "query_id")
    private String queryId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @Column(name = "scheduled_for_deletion")
    private Boolean scheduledForDeletion;

    @Column(name = "status")
    private String status;

    @Column(name = "token")
    private String token;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
