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
@Table(name = "trade_republic_items")
public class TradeRepublicItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "brokerage_account_id")
    private String brokerageAccountId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency")
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "name")
    private String name;

    @Column(name = "newest_event_id")
    private String newestEventId;

    @Column(name = "pending_account_setup", nullable = false)
    private Boolean pendingAccountSetup;

    @Column(name = "pending_login_state")
    private String pendingLoginState;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "scheduled_for_deletion", nullable = false)
    private Boolean scheduledForDeletion;

    @Column(name = "session_blob")
    private String sessionBlob;

    @Column(name = "status", nullable = false)
    private String status;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "timeline_cursors", nullable = false)
    private JsonNode timelineCursors;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
