package com.butler.app.api.admin;

import com.butler.app.api.admin.AdminApiModels.SsoProviderRequest;
import com.butler.app.api.admin.AdminApiModels.SsoProviderResponse;
import com.butler.app.entities.SsoProvider;
import com.butler.app.repositories.SsoProviderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping({"/api/admin/sso_providers", "/admin/sso_providers"})
public class AdminSsoProviderController {

    private final SsoProviderRepository providers;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AdminSsoProviderController(SsoProviderRepository providers) {
        this.providers = providers;
    }

    @GetMapping
    public List<SsoProviderResponse> index() {
        return providers.findAll().stream().map(SsoProviderResponse::from).toList();
    }

    @GetMapping("/{id}")
    public SsoProviderResponse show(@PathVariable UUID id) {
        return SsoProviderResponse.from(findProvider(id));
    }

    @PostMapping
    public ResponseEntity<SsoProviderResponse> create(@RequestBody SsoProviderRequest request) {
        LocalDateTime now = LocalDateTime.now();
        SsoProvider provider = new SsoProvider();
        provider.setCreatedAt(now);
        apply(provider, request, true);
        provider.setUpdatedAt(now);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(SsoProviderResponse.from(providers.save(provider)));
    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public SsoProviderResponse update(@PathVariable UUID id, @RequestBody SsoProviderRequest request) {
        SsoProvider provider = findProvider(id);
        apply(provider, request, false);
        provider.setUpdatedAt(LocalDateTime.now());
        return SsoProviderResponse.from(providers.save(provider));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable UUID id) {
        providers.delete(findProvider(id));
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/toggle")
    public SsoProviderResponse toggle(@PathVariable UUID id) {
        SsoProvider provider = findProvider(id);
        provider.setEnabled(!Boolean.TRUE.equals(provider.getEnabled()));
        provider.setUpdatedAt(LocalDateTime.now());
        return SsoProviderResponse.from(providers.save(provider));
    }

    @PostMapping("/{id}/test_connection")
    public Map<String, Object> testConnection(@PathVariable UUID id) {
        SsoProvider provider = findProvider(id);
        if (provider.getIssuer() == null || provider.getIssuer().isBlank()) {
            return Map.of("success", false, "message", "Provider issuer is not configured.");
        }

        try {
            URI issuer = URI.create(provider.getIssuer());
            if (!"https".equalsIgnoreCase(issuer.getScheme()) || issuer.getHost() == null
                || issuer.getUserInfo() != null) {
                return Map.of("success", false, "message", "Issuer must be a valid HTTPS URL.");
            }

            String base = provider.getIssuer().replaceAll("/+$", "");
            URI discoveryUri = URI.create(base + "/.well-known/openid-configuration");
            java.net.http.HttpClient client = java.net.http.HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .followRedirects(java.net.http.HttpClient.Redirect.NEVER)
                .build();
            java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder(discoveryUri)
                .timeout(Duration.ofSeconds(8))
                .GET()
                .build();
            java.net.http.HttpResponse<String> response = client.send(
                request,
                java.net.http.HttpResponse.BodyHandlers.ofString()
            );
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                return Map.of(
                    "success",
                    false,
                    "message",
                    "OIDC discovery returned HTTP " + response.statusCode() + "."
                );
            }
            String discoveredIssuer = objectMapper.readTree(response.body()).path("issuer").asText();
            boolean issuerMatches = provider.getIssuer().replaceAll("/+$", "")
                .equals(discoveredIssuer.replaceAll("/+$", ""));
            return Map.of(
                "success",
                issuerMatches,
                "message",
                issuerMatches ? "OIDC discovery succeeded." : "Discovered issuer does not match the configured issuer."
            );
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            return Map.of("success", false, "message", "OIDC discovery request was interrupted.");
        } catch (java.io.IOException | IllegalArgumentException exception) {
            return Map.of("success", false, "message", "Unable to reach or parse the OIDC discovery endpoint.");
        }
    }

    private SsoProvider findProvider(UUID id) {
        return providers.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SSO provider not found."));
    }

    private void apply(SsoProvider provider, SsoProviderRequest request, boolean creating) {
        if (request.name() != null) {
            provider.setName(request.name());
        } else if (creating) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name is required.");
        }
        if (request.label() != null) {
            provider.setLabel(request.label());
        } else if (creating) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "label is required.");
        }
        if (request.strategy() != null) {
            provider.setStrategy(request.strategy());
        } else if (creating) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "strategy is required.");
        }
        if (request.issuer() != null) {
            provider.setIssuer(request.issuer());
        }
        if (request.clientId() != null) {
            provider.setClientId(request.clientId());
        }
        if (request.clientSecret() != null) {
            provider.setClientSecret(request.clientSecret());
        }
        if (request.redirectUri() != null) {
            provider.setRedirectUri(request.redirectUri());
        }
        if (request.icon() != null) {
            provider.setIcon(request.icon());
        }
        if (request.enabled() != null) {
            provider.setEnabled(request.enabled());
        } else if (creating) {
            provider.setEnabled(true);
        }
        if (request.settings() != null) {
            provider.setSettings(request.settings());
        } else if (creating) {
            provider.setSettings(objectMapper.createObjectNode());
        }
    }
}
