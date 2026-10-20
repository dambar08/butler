package com.butler.app.config;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.butler.app.api.HealthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HealthController.class)
@Import({SecurityConfig.class, SecurityConfigTests.OAuthClientConfiguration.class})
class SecurityConfigTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void oauthLoginRedirectsToConfiguredProvider() throws Exception {
        mockMvc.perform(get("/oauth2/authorization/butler"))
            .andExpect(status().is3xxRedirection())
            .andExpect(header().string("Location", startsWith("https://identity.example.com/authorize?")));
    }

    @Test
    void oauthConfigurationRequiresAuthenticationForNonPublicRoutes() throws Exception {
        mockMvc.perform(get("/api/private"))
            .andExpect(status().isUnauthorized());
    }

    @Test
    void accountsEndpointRequiresAuthentication() throws Exception {
        mockMvc.perform(get("/api/v1/accounts"))
            .andExpect(status().isUnauthorized());
    }

    @Test
    void browserRequestsAreRedirectedToLoginWhenOauthIsEnabled() throws Exception {
        mockMvc.perform(get("/api/private").accept(MediaType.TEXT_HTML))
            .andExpect(status().is3xxRedirection())
            .andExpect(header().string("Location", "/oauth2/authorization/butler"));
    }

    @Test
    void healthEndpointRemainsPublicWithOauthEnabled() throws Exception {
        mockMvc.perform(get("/api/health"))
            .andExpect(status().isOk());
    }

    @TestConfiguration
    static class OAuthClientConfiguration {

        @Bean
        ClientRegistrationRepository clientRegistrationRepository() {
            ClientRegistration registration = ClientRegistration.withRegistrationId("butler")
                .clientId("test-client")
                .clientSecret("test-secret")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid", "profile", "email")
                .authorizationUri("https://identity.example.com/authorize")
                .tokenUri("https://identity.example.com/token")
                .userInfoUri("https://identity.example.com/userinfo")
                .userNameAttributeName("sub")
                .clientName("Butler")
                .build();
            return new InMemoryClientRegistrationRepository(registration);
        }
    }
}
