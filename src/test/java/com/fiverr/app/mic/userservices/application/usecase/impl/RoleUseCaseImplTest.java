package com.fiverr.app.mic.userservices.application.usecase.impl;

import com.fiverr.app.mic.userservices.domain.Role;
import com.fiverr.app.mic.userservices.domain.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.fiverr.app.mic.userservices.provider.CommonProvider.ID_ONE;
import static com.fiverr.app.mic.userservices.provider.RoleProvider.getRoleOne;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleUseCaseImplTest {

    @Mock
    private RoleRepository roleRepository;
    @InjectMocks
    private RoleUseCaseImpl roleUseCase;

    @Test
    void create() {

        // Arrange
        when(roleRepository.create(getRoleOne())).thenReturn(getRoleOne());

        // Act
        Role role = roleUseCase.create(getRoleOne());

        // Assert
        assertNotNull(role);
        assertEquals(getRoleOne(), role);

        // Verify
        verify(roleRepository).create(getRoleOne());

    }

    @Test
    void getById() {

        // Arrange
        when(roleRepository.getById(ID_ONE)).thenReturn(getRoleOne());

        // Act
        Role role = roleUseCase.getById(ID_ONE);

        // Assert
        assertNotNull(role);
        assertEquals(getRoleOne(), role);

        // Verify
        verify(roleRepository).getById(ID_ONE);
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {

        // Arrange

        // Act

        // Assert

        // Verify
    }

    @Test
    void deleteById() {

        // Arrange

        // Act

        // Assert

        // Verify
    }
}