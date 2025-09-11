package com.fiverr.app.mic.userservices.application.security.cors;

import com.fiverr.app.mic.userservices.api.controller.BaseIntegration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

class CorsRegistryConfigurationTest extends BaseIntegration {

    private static final String ALLOWED_ORIGIN = "http://localhost:4200";
    private static final String FORBIDDEN_ORIGIN = "https://www.evil-site.com";

    @Test
    @DisplayName("Verification of option successfully.")
    void testCorsHeadersArePresentForAllowedOrigin() {
        client.options()
                .uri("/v1/users")
                .header("Origin", ALLOWED_ORIGIN)
                .header("Access-Control-Request-Method", HttpMethod.GET.name())
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Access-Control-Allow-Origin", ALLOWED_ORIGIN)
                .expectHeader().valueEquals("Access-Control-Allow-Credentials", "true");
    }

    @Test
    @DisplayName("Verification option failure.")
    void testCorsHeadersAreNotPresentForForbiddenOrigin() {
        client.options()
                .uri("/v1/users")
                .header("Origin", FORBIDDEN_ORIGIN)
                .header("Access-Control-Request-Method", HttpMethod.GET.name())
                .exchange()
                .expectStatus().isForbidden();
    }
}