package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "impersonation_session_logs")
public class ImpersonationSessionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "action")
    private String action;

    @Column(name = "controller")
    private String controller;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "impersonation_session_id", nullable = false)
    private ImpersonationSession impersonationSession;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "method")
    private String method;

    @Column(name = "path")
    private String path;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "user_agent")
    private String userAgent;
}
