package com.butler.app.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.io.ClassPathResource;

class ApplicationProfileConfigurationTests {

    private final YamlPropertySourceLoader yamlLoader = new YamlPropertySourceLoader();

    @Test
    void jobRunrProcessesJobsAndCreatesItsStorageTablesWithoutExposingDashboard() throws IOException {
        assertEquals("true", commonProperty("jobrunr.job-scheduler.enabled"));
        assertEquals("true", commonProperty("jobrunr.background-job-server.enabled"));
        assertEquals("false", commonProperty("jobrunr.dashboard.enabled"));
        assertEquals("false", commonProperty("jobrunr.database.skip-create"));
    }

    @Test
    void baseConfigurationDefaultsToDevelopmentProfile() throws IOException {
        Object activeProfiles = yamlLoader.load(
            "application",
            new ClassPathResource("application.yml")
        ).get(0).getProperty("spring.profiles.active");

        assertEquals("${SPRING_PROFILES_ACTIVE:development}", String.valueOf(activeProfiles));
    }

    @Test
    void developmentProfileUsesLocalDatabaseAndAllowsSchemaUpdates() throws IOException {
        assertTrue(property("development", "spring.datasource.url")
            .contains("jdbc:postgresql://localhost:5432/butler_dev"));
        assertEquals("update", property("development", "spring.jpa.hibernate.ddl-auto"));
        assertEquals("true", property("development", "spring.jpa.show-sql"));
        assertEquals("true", property("development", "spring.jpa.properties.hibernate.enable_lazy_load_no_trans"));
    }

    @Test
    void stagingProfileValidatesSchemaAndUsesStagingDatabase() throws IOException {
        assertTrue(property("staging", "spring.datasource.url")
            .contains("jdbc:postgresql://staging-db:5432/butler_staging"));
        assertEquals("validate", property("staging", "spring.jpa.hibernate.ddl-auto"));
        assertEquals("${DB_USERNAME}", property("staging", "spring.datasource.username"));
        assertEquals("${DB_PASSWORD}", property("staging", "spring.datasource.password"));
    }

    @Test
    void productionProfileValidatesSchemaAndUsesProductionDatabase() throws IOException {
        assertTrue(property("production", "spring.datasource.url")
            .contains("jdbc:postgresql://prod-db:5432/butler_prod"));
        assertEquals("validate", property("production", "spring.jpa.hibernate.ddl-auto"));
        assertEquals("${DB_USERNAME}", property("production", "spring.datasource.username"));
        assertEquals("${DB_PASSWORD}", property("production", "spring.datasource.password"));
        assertEquals("WARN", property("production", "logging.level.root"));
    }

    private String property(String profile, String key) throws IOException {
        Object value = yamlLoader.load(
            profile,
            new ClassPathResource("application-" + profile + ".yml")
        ).get(0).getProperty(key);
        return String.valueOf(value);
    }

    private String commonProperty(String key) throws IOException {
        Object value = yamlLoader.load(
            "application",
            new ClassPathResource("application.yml")
        ).get(0).getProperty(key);
        return String.valueOf(value);
    }
}
