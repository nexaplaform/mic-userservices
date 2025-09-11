package com.fiverr.app.mic.userservices.api.service.mapper;

import com.fiverr.app.mic.userservices.domain.Role;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserDtoMapperTest {

    private final UserDtoMapper mapper = Mappers.getMapper(UserDtoMapper.class);

    @Test
    void mapRoleIdsToRoles_OK() {

        // Arrange
        List<Long> rolesIds = List.of(1L, 2L);
        List<Role> roles = List.of(
                Role.builder()
                        .id(1L)
                        .build(),
                Role.builder()
                        .id(2L)
                        .build());

        // Act
        List<Role> rolesResponse =mapper.mapRoleIdsToRoles(rolesIds);

        // Assert
        assertNotNull(roles);
        assertEquals(roles, rolesResponse);
    }
}