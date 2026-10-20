package com.butler.app.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
        HttpSecurity http,
        ObjectProvider<ClientRegistrationRepository> clientRegistrations
    ) throws Exception {
        boolean oauthEnabled = clientRegistrations.getIfAvailable() != null;
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/api/admin/**", "/admin/**").hasRole("ADMIN");
                auth.requestMatchers("/api/search/**").authenticated();
                auth.requestMatchers("/api/v1/accounts/**").authenticated();
                auth.requestMatchers(
                    "/",
                    "/index.html",
                    "/favicon.ico",
                    "/assets/**",
                    "/error",
                    "/api/health",
                    "/swagger-ui/**",
                    "/v3/api-docs/**"
                ).permitAll();
                if (oauthEnabled) {
                    auth.anyRequest().authenticated();
                } else {
                    auth.anyRequest().permitAll();
                }
            })
            .httpBasic(Customizer.withDefaults())
            .formLogin(AbstractHttpConfigurer::disable);

        if (oauthEnabled) {
            http.oauth2Login(Customizer.withDefaults());
        }

        return http.build();
    }

    @Bean
    @ConditionalOnExpression(
        "'${BUTLER_ADMIN_USERNAME:}' != '' and '${BUTLER_ADMIN_PASSWORD:}' != ''"
    )
    public UserDetailsService adminUserDetailsService(
        @Value("${BUTLER_ADMIN_USERNAME}") String username,
        @Value("${BUTLER_ADMIN_PASSWORD}") String password
    ) {
        String encodedPassword = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password);
        return new InMemoryUserDetailsManager(
            User.withUsername(username).password(encodedPassword).roles("ADMIN").build()
        );
    }
}
