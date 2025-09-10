package com.fiverr.app.mic.userservices.api.provider;

import com.fiverr.app.mic.userservices.api.service.dto.in.RoleDtoIn;
import com.fiverr.app.mic.userservices.api.service.dto.out.RoleDtoOut;
import com.fiverr.app.mic.userservices.domain.Role;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.entity.RoleEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.fiverr.app.mic.userservices.api.provider.CommonProvider.ID_ONE;
import static com.fiverr.app.mic.userservices.api.provider.CommonProvider.ID_TWO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleProvider {

    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String BASIC_ROLE_FOR_USERS = "Basic role for users.";
    public static final String ADMIN_ROLE_FOR_USERS = "Admin role for users.";

    public static RoleDtoIn getRoleDtoInOne() {
        return RoleDtoIn.builder()
                .name(ROLE_USER)
                .description(BASIC_ROLE_FOR_USERS)
                .active(true)
                .build();
    }

    public static RoleDtoIn getRoleDtoInTwo() {
        return RoleDtoIn.builder()
                .name(ROLE_ADMIN)
                .description(ADMIN_ROLE_FOR_USERS)
                .active(true)
                .build();
    }

    public static Role getRoleOne() {
        return Role.builder()
                .id(ID_ONE)
                .name(ROLE_USER)
                .description(BASIC_ROLE_FOR_USERS)
                .active(true)
                .build();
    }

    public static Role getRoleTwo() {
        return Role.builder()
                .id(ID_TWO)
                .name(ROLE_ADMIN)
                .description(ADMIN_ROLE_FOR_USERS)
                .active(true)
                .build();
    }

    public static RoleEntity getRoleEntityOne() {
        return RoleEntity.builder()
                .name(ROLE_USER)
                .description(BASIC_ROLE_FOR_USERS)
                .active(true)
                .build();
    }

    public static RoleEntity getRoleEntityTwo() {
        return RoleEntity.builder()
                .name(ROLE_ADMIN)
                .description(ADMIN_ROLE_FOR_USERS)
                .active(true)
                .build();
    }

    public static RoleDtoOut getRoleDtoOutOne() {
        return RoleDtoOut.builder()
                .id(ID_ONE)
                .name(ROLE_USER)
                .description(BASIC_ROLE_FOR_USERS)
                .active(true)
                .build();
    }

    public static RoleDtoOut getRoleDtoOutTwo() {
        return RoleDtoOut.builder()
                .id(ID_TWO)
                .name(ROLE_ADMIN)
                .description(ADMIN_ROLE_FOR_USERS)
                .active(true)
                .build();
    }
}
