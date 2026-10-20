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
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "active_impersonator_session_id", nullable = true)
    private ImpersonationSession activeImpersonatorSession;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "data")
    private JsonNode data;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "ip_address_digest")
    private String ipAddressDigest;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "prev_transaction_page_params")
    private JsonNode prevTransactionPageParams;

    @Column(name = "subscribed_at")
    private LocalDateTime subscribedAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "user_agent")
    private String userAgent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
