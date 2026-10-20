package com.butler.app.api.admin;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.butler.app.repositories.FamilyRepository;
import com.butler.app.repositories.InvitationRepository;
import com.butler.app.repositories.SsoIdentityBlockRepository;
import com.butler.app.repositories.SsoProviderRepository;
import com.butler.app.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class AdminApiControllerTests {

    private final SsoProviderRepository providers = mock(SsoProviderRepository.class);
    private final SsoIdentityBlockRepository identityBlocks = mock(SsoIdentityBlockRepository.class);
    private final UserRepository users = mock(UserRepository.class);
    private final FamilyRepository families = mock(FamilyRepository.class);
    private final InvitationRepository invitations = mock(InvitationRepository.class);
    private final EntityManager entityManager = mock(EntityManager.class);
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(
            new AdminSsoProviderController(providers),
            new AdminResourcesController(users, families, invitations, identityBlocks),
            new AdminSystemHealthController(entityManager)
        ).build();
    }

    @Test
    void adminCollectionRoutesAreRegistered() throws Exception {
        mockMvc.perform(get("/api/admin/sso_providers"))
            .andExpect(status().isOk());
        mockMvc.perform(get("/api/admin/users"))
            .andExpect(status().isOk());
        mockMvc.perform(get("/admin/sso_providers"))
            .andExpect(status().isOk());
        mockMvc.perform(get("/admin/users"))
            .andExpect(status().isOk());
    }

    @Test
    void healthRoutesAreRegisteredAndReportDatabaseStatus() throws Exception {
        Query query = mock(Query.class);
        when(entityManager.createNativeQuery("SELECT 1")).thenReturn(query);
        when(query.getSingleResult()).thenReturn(1);

        mockMvc.perform(get("/api/admin/system_health"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.database").value("connected"));
        mockMvc.perform(get("/api/admin/system_health/ai_status"))
            .andExpect(status().isOk());
        mockMvc.perform(get("/api/admin/system_health/hosted_usage"))
            .andExpect(status().isNotImplemented())
            .andExpect(jsonPath("$.success").value(false));
    }

    @Test
    void unavailableIntegrationsReportNotImplemented() throws Exception {
        mockMvc.perform(post("/api/admin/system_health/verify_worker_ai"))
            .andExpect(status().isNotImplemented())
            .andExpect(jsonPath("$.success").value(false));
        mockMvc.perform(post("/api/admin/system_health/send_test_push"))
            .andExpect(status().isNotImplemented())
            .andExpect(jsonPath("$.success").value(false));
    }
}
