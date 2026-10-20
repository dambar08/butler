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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "ai_enabled", nullable = false)
    private Boolean aiEnabled;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "default_account_id", nullable = true)
    private Account defaultAccount;

    @Column(name = "default_account_order")
    private String defaultAccountOrder;

    @Column(name = "default_period", nullable = false)
    private String defaultPeriod;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "goals")
    private String goals;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "last_viewed_chat_id", nullable = true)
    private Chat lastViewedChat;

    @Column(name = "locale")
    private String locale;

    @Column(name = "onboarded_at")
    private LocalDateTime onboardedAt;

    @Column(name = "otp_backup_codes")
    private String otpBackupCodes;

    @Column(name = "otp_last_used_at")
    private LocalDateTime otpLastUsedAt;

    @Column(name = "otp_required", nullable = false)
    private Boolean otpRequired;

    @Column(name = "otp_secret")
    private String otpSecret;

    @Column(name = "password_digest")
    private String passwordDigest;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "preferences", nullable = false)
    private JsonNode preferences;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "rule_prompt_dismissed_at")
    private LocalDateTime rulePromptDismissedAt;

    @Column(name = "rule_prompts_disabled")
    private Boolean rulePromptsDisabled;

    @Column(name = "sessions_count", nullable = false)
    private Integer sessionsCount;

    @Column(name = "set_onboarding_goals_at")
    private LocalDateTime setOnboardingGoalsAt;

    @Column(name = "set_onboarding_preferences_at")
    private LocalDateTime setOnboardingPreferencesAt;

    @Column(name = "show_ai_sidebar")
    private Boolean showAiSidebar;

    @Column(name = "show_sidebar")
    private Boolean showSidebar;

    @Column(name = "theme")
    private String theme;

    @Column(name = "ui_layout")
    private String uiLayout;

    @Column(name = "unconfirmed_email")
    private String unconfirmedEmail;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "webauthn_id")
    private String webauthnId;
}
