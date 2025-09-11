package com.fiverr.app.mic.userservices.api.controller;

import com.fiverr.app.mic.userservices.api.service.dto.out.RoleDtoOut;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.repository.RoleJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

import static com.fiverr.app.mic.userservices.provider.RoleProvider.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RoleControllerTest extends BaseIntegration {

    public static final String ID = "/1";
    public static final String PATH = "/v1/roles";

    @Autowired
    protected RoleJpaRepository roleJpaRepository;

    @Test
    @DisplayName("Create role.")
    void create() {

        RoleDtoOut role = client
                .post()
                .uri(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getRoleDtoInOne())
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(RoleDtoOut.class)
                .returnResult()
                .getResponseBody();

        assertThat(getRoleDtoOutOne())
                .usingRecursiveComparison()
                .isEqualTo(role);
    }

    @Test
    @DisplayName("Update role.")
    void update() {

        roleJpaRepository.save(getRoleEntityOne());

        RoleDtoOut role = client.put()
                .uri(PATH + ID)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getRoleEntityTwo().withId(1L))
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(RoleDtoOut.class)
                .returnResult()
                .getResponseBody();

        assertThat(getRoleDtoOutTwo().withId(1L))
                .usingRecursiveComparison()
                .isEqualTo(role);
    }

    @Test
    @DisplayName("Obtain role by id.")
    void getById() {

        roleJpaRepository.save(getRoleEntityOne());

        RoleDtoOut role = client
                .get()
                .uri(PATH + ID)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(RoleDtoOut.class)
                .returnResult()
                .getResponseBody();
        assertThat(getRoleDtoOutOne())
                .usingRecursiveComparison()
                .isEqualTo(role);
    }

    @Test
    @DisplayName("Delete role by id.")
    void delete() {

        roleJpaRepository.save(getRoleEntityOne());
        client.delete()
                .uri(PATH + ID)
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    @DisplayName("Get roles paginated.")
    void findAll() {

        roleJpaRepository.saveAll(List.of(getRoleEntityOne(), getRoleEntityTwo()));

        List<RoleDtoOut> roles = client.get()
                .uri(PATH)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(RoleDtoOut.class)
                .returnResult()
                .getResponseBody();

        assertThat(List.of(getRoleDtoOutOne(), getRoleDtoOutTwo()))
                .usingRecursiveComparison()
                .isEqualTo(roles);
    }
}