package com.fiverr.app.mic.userservices.api.service.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RoleDtoMapperTest {

    private final RoleDtoMapper mapper = Mappers.getMapper(RoleDtoMapper.class);

    @Test
    void toUpperCase() {

        // Arrange
        String roleName = "role_user";

        // Act
        String roleConverted = mapper.toUpperCase(roleName);

        //Assert
        assertNotNull(roleConverted);
        assertEquals(roleName.toUpperCase(), roleConverted);
    }
}