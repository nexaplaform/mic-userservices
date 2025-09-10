package com.fiverr.app.mic.userservices.api.provider;

import com.fiverr.app.mic.userservices.api.service.dto.in.UserDtoIn;
import com.fiverr.app.mic.userservices.api.service.dto.out.UserDtoOut;
import com.fiverr.app.mic.userservices.domain.User;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.entity.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fiverr.app.mic.userservices.api.provider.CommonProvider.ID_ONE;
import static com.fiverr.app.mic.userservices.api.provider.CommonProvider.ID_TWO;
import static com.fiverr.app.mic.userservices.api.provider.RoleProvider.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserProvider {

    public static UserDtoIn getUserDtoInOne() {
        return UserDtoIn.builder()
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("5 555 5555")
                .email("johnDoe@example.com")
                .password("123456789")
                .active(true)
                .roles(List.of(1L, 2L))
                .build();
    }

    public static UserDtoIn getUserDtoInTwo() {
        return UserDtoIn.builder()
                .firstName("Jose")
                .lastName("Smith")
                .phoneNumber("6 666 6666")
                .email("joseSmith@example.com")
                .password("987654321")
                .active(true)
                .roles(List.of(1L, 2L))
                .build();
    }

    public static User getUserOne() {
        return User.builder()
                .id(ID_ONE)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("5 555 5555")
                .email("johnDoe@example.com")
                .password("123456789")
                .active(true)
                .roles(List.of(getRoleOne(),getRoleTwo()))
                .build();
    }

    public static User getUserTwo() {
        return User.builder()
                .id(ID_TWO)
                .firstName("Jose")
                .lastName("Smith")
                .phoneNumber("6 666 6666")
                .email("joseSmith@example.com")
                .password("987654321")
                .active(true)
                .roles(List.of(getRoleOne()))
                .build();
    }

    public static UserEntity getUserEntityOne() {
        return UserEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("5 555 5555")
                .email("johnDoe@example.com")
                .password("123456789")
                .active(true)
                .roles(List.of(getRoleEntityOne(),getRoleEntityTwo()))
                .build();
    }

    public static UserEntity getUserEntityTwo() {
        return UserEntity.builder()
                .firstName("Jose")
                .lastName("Smith")
                .phoneNumber("6 666 6666")
                .email("joseSmith@example.com")
                .password("987654321")
                .active(true)
                .roles(List.of(getRoleEntityOne()))
                .build();
    }

    public static UserDtoOut getUserDtoOutOne() {
        return UserDtoOut.builder()
                .id(ID_ONE)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("5 555 5555")
                .email("johnDoe@example.com")
                .active(true)
                .roles(List.of(getRoleDtoOutOne(),getRoleDtoOutTwo()))
                .build();
    }

    public static UserDtoOut getUserDtoOutTwo() {
        return UserDtoOut.builder()
                .id(ID_TWO)
                .firstName("Jose")
                .lastName("Smith")
                .phoneNumber("6 666 6666")
                .email("joseSmith@example.com")
                .active(true)
                .roles(List.of(getRoleDtoOutOne()))
                .build();
    }
}
