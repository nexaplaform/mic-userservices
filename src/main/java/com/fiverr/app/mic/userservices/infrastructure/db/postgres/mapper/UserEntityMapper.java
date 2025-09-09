package com.fiverr.app.mic.userservices.infrastructure.db.postgres.mapper;

import com.fiverr.app.mic.userservices.domain.User;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "active", source = "active")
    User toModel(UserEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "active", source = "active")
    UserEntity toEntity(User user);

    List<User> toModelList(List<UserEntity> entities);
}
