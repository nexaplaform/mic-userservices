package com.fiverr.app.mic.userservices.infrastructure.db.postgres.mapper;

import com.fiverr.app.mic.userservices.domain.Role;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "active", source = "active")
    Role toModel(RoleEntity entity);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "active", source = "active")
    RoleEntity toEntity(Role entity);

    List<Role> toModelList(List<RoleEntity> entities);
}
