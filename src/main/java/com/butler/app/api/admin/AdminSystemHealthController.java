package com.butler.app.api.admin;

import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/admin/system_health", "/admin/system_health"})
public class AdminSystemHealthController {

    private final EntityManager entityManager;

    public AdminSystemHealthController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping
    public Map<String, Object> show() {
        entityManager.createNativeQuery("SELECT 1").getSingleResult();
        return Map.of(
            "status", "ok",
            "database", "connected",
            "timestamp", Instant.now().toString()
        );
    }

    @GetMapping("/ai_status")
    public Map<String, Object> aiStatus() {
        boolean configured = System.getenv("OPENAI_API_KEY") != null
            && !System.getenv("OPENAI_API_KEY").isBlank();
        return Map.of(
            "configured", configured,
            "status", configured ? "configured" : "not_configured"
        );
    }

    @GetMapping("/hosted_usage")
    public ResponseEntity<Map<String, Object>> hostedUsage() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Map.of(
            "success", false,
            "message", "Hosted usage reporting is not configured."
        ));
    }

    @PostMapping("/verify_worker_ai")
    public ResponseEntity<Map<String, Object>> verifyWorkerAi() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Map.of(
            "success", false,
            "message", "Worker AI verification is not configured."
        ));
    }

    @PostMapping("/send_test_push")
    public ResponseEntity<Map<String, Object>> sendTestPush() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Map.of(
            "success", false,
            "message", "Push delivery is not configured."
        ));
    }
}
