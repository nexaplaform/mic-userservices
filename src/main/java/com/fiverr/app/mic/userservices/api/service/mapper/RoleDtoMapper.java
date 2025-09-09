package com.fiverr.app.mic.userservices.api.service.mapper;

import com.fiverr.app.mic.userservices.api.service.dto.in.RoleDtoIn;
import com.fiverr.app.mic.userservices.api.service.dto.out.RoleDtoOut;
import com.fiverr.app.mic.userservices.domain.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleDtoMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "active", source = "active")
    RoleDtoOut toDtoOut(Role role);

    List<RoleDtoOut> toDtoOutList(List<Role> roles);

    @Mapping(target = "name", qualifiedByName = "toUpperCase")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "active", source = "active")
    Role toDomain(RoleDtoIn dtoIn);

    @Named("toUpperCase")
    default String toUpperCase(String value) {
        return value != null ? value.toUpperCase() : null;
    }


}
