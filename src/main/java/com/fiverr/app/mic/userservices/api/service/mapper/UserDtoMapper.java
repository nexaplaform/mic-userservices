package com.fiverr.app.mic.userservices.api.service.mapper;

import com.fiverr.app.mic.userservices.api.service.dto.in.UserDtoIn;
import com.fiverr.app.mic.userservices.api.service.dto.out.UserDtoOut;
import com.fiverr.app.mic.userservices.domain.Role;
import com.fiverr.app.mic.userservices.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "fullName", expression = "java(getFullName(user))")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "active", source = "active")
    UserDtoOut toDto(User user);

    default String getFullName(User user) {
        if (user == null) {
            return null;
        }
        String firstName = Objects.isNull(user.getFirstName()) ? null : user.getFirstName();
        String lastName = Objects.isNull(user.getLastName()) ? null : user.getLastName();
        return firstName + " " + lastName;
    }

    List<UserDtoOut> toDtoList(List<User> user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoleIdsToRoles")
    User toDomain(UserDtoIn userDtoIn);

    @Named("mapRoleIdsToRoles")
    default List<Role> mapRoleIdsToRoles(List<Long> rolesIds) {
        if (rolesIds == null) {
            return Collections.emptyList();
        }
        return rolesIds.stream().map(id -> Role.builder()
                .id(id)
                .build()).toList();
    }
}
