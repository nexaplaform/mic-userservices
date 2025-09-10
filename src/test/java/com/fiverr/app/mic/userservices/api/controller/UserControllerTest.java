package com.fiverr.app.mic.userservices.api.controller;

import com.fiverr.app.mic.userservices.api.service.dto.out.UserDtoOut;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.entity.RoleEntity;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.repository.RoleJpaRepository;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.repository.UserJpaRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static com.fiverr.app.mic.userservices.api.provider.RoleProvider.getRoleEntityOne;
import static com.fiverr.app.mic.userservices.api.provider.RoleProvider.getRoleEntityTwo;
import static com.fiverr.app.mic.userservices.api.provider.UserProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserControllerTest extends BaseIntegration{

    private static final String USER_ID = "/1";
    private static final String USER_PATH = "/v1/users";

    @Autowired
    private WebTestClient client;
    @Autowired
    protected UserJpaRepository userJpaRepository;
    @Autowired
    protected RoleJpaRepository roleJpaRepository;

    @Test
    @DisplayName("Create user.")
    void create() {

        roleJpaRepository.saveAll(List.of(getRoleEntityOne(), getRoleEntityTwo()));

        UserDtoOut user = client
                .post()
                .uri(USER_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getUserDtoInOne())
                .exchange()
                .expectStatus().isCreated()
                .expectBody(UserDtoOut.class)
                .returnResult()
                .getResponseBody();

        assertThat(getUserDtoOutOne())
                .usingRecursiveComparison()
                .isEqualTo(user);
    }

    @Test
    @DisplayName("Update user.")
    void update() {

        List<RoleEntity> roleEntities = roleJpaRepository.saveAll(List.of(getRoleEntityOne(), getRoleEntityTwo()));
        userJpaRepository.save(getUserEntityOne().withRoles(roleEntities));

        UserDtoOut user = client.put()
                .uri(USER_PATH + USER_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getUserDtoInTwo().withRoles(List.of(1L)))
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(UserDtoOut.class)
                .returnResult()
                .getResponseBody();

        AssertionsForClassTypes.assertThat(getUserDtoOutTwo().withId(1L))
                .usingRecursiveComparison()
                .isEqualTo(user);
    }

    @Test
    @DisplayName("Obtain user by id.")
    void getById() {

        List<RoleEntity> roles = roleJpaRepository.saveAll(List.of(getRoleEntityOne(), getRoleEntityTwo()));
        userJpaRepository.save(getUserEntityOne().withRoles(roles));

        UserDtoOut user = client.get()
                .uri(USER_PATH + USER_ID)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(UserDtoOut.class)
                .returnResult()
                .getResponseBody();

        assertThat(getUserDtoOutOne())
                .usingRecursiveComparison()
                .isEqualTo(user);
    }

    @Test
    @DisplayName("Delete user by id.")
    void delete() {

        RoleEntity roleEntity = roleJpaRepository.save(getRoleEntityOne());
        userJpaRepository.save(getUserEntityOne().withRoles(List.of(roleEntity)));
        client.delete()
                .uri(USER_PATH + USER_ID)
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    @DisplayName("Get roles paginated.")
    void findAll() {

        List<RoleEntity> roles = roleJpaRepository.saveAll(List.of(getRoleEntityOne(), getRoleEntityTwo()));
        userJpaRepository.save(getUserEntityOne().withRoles(roles));

        List<UserDtoOut> users = client
                .get()
                .uri(USER_PATH + "?page=0&size=9&sort=ASC")
                .exchange()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectStatus().isOk()
                .expectBodyList(UserDtoOut.class)
                .returnResult()
                .getResponseBody();

        assertThat(List.of(getUserDtoOutOne()))
                .usingRecursiveComparison()
                .isEqualTo(users);
    }
}