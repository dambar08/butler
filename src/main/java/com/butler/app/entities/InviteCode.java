package com.butler.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "invite_codes")
public class InviteCode {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "token_digest")
    private String tokenDigest;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
