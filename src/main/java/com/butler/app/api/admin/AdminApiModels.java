package com.butler.app.api.admin;

import com.butler.app.entities.SsoProvider;
import com.butler.app.entities.User;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.LocalDateTime;
import java.util.UUID;

public final class AdminApiModels {

    private AdminApiModels() {
    }

    public record SsoProviderRequest(
        String name,
        String label,
        String strategy,
        String issuer,
        String clientId,
        String clientSecret,
        String redirectUri,
        String icon,
        Boolean enabled,
        JsonNode settings
    ) {
    }

    public record SsoProviderResponse(
        UUID id,
        String name,
        String label,
        String strategy,
        String issuer,
        String clientId,
        String redirectUri,
        String icon,
        boolean enabled,
        JsonNode settings,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        public static SsoProviderResponse from(SsoProvider provider) {
            return new SsoProviderResponse(
                provider.getId(),
                provider.getName(),
                provider.getLabel(),
                provider.getStrategy(),
                provider.getIssuer(),
                provider.getClientId(),
                provider.getRedirectUri(),
                provider.getIcon(),
                Boolean.TRUE.equals(provider.getEnabled()),
                provider.getSettings(),
                provider.getCreatedAt(),
                provider.getUpdatedAt()
            );
        }
    }

    public record UserResponse(
        UUID id,
        String email,
        String firstName,
        String lastName,
        String role,
        boolean active,
        UUID familyId,
        LocalDateTime createdAt,
        LocalDateTime lastLoginAt
    ) {
        public static UserResponse from(User user) {
            return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                Boolean.TRUE.equals(user.getActive()),
                user.getFamily() == null ? null : user.getFamily().getId(),
                user.getCreatedAt(),
                user.getLastLoginAt()
            );
        }
    }

    public record UserUpdateRequest(
        String email,
        String firstName,
        String lastName,
        String role,
        Boolean active
    ) {
    }
}
