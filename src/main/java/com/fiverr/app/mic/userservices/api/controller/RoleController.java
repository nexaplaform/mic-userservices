package com.fiverr.app.mic.userservices.api.controller;

import com.fiverr.app.mic.userservices.api.service.RoleApi;
import com.fiverr.app.mic.userservices.api.service.dto.in.RoleDtoIn;
import com.fiverr.app.mic.userservices.api.service.dto.in.SortEnumDTO;
import com.fiverr.app.mic.userservices.api.service.dto.out.RoleDtoOut;
import com.fiverr.app.mic.userservices.api.service.mapper.RoleDtoMapper;
import com.fiverr.app.mic.userservices.application.usecase.RoleUseCase;
import com.fiverr.app.mic.userservices.domain.Role;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/roles")
@Tag(name = "Roles Operations.", description = "Operations related to user roles.")
public class RoleController implements RoleApi {

    private final RoleUseCase roleUseCase;
    private final RoleDtoMapper mapper;

    @Override
    public ResponseEntity<RoleDtoOut> create(RoleDtoIn dto) {
        Role role =  mapper.toDomain(dto);
        return new ResponseEntity<>(mapper.toDtoOut(roleUseCase.create(role)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RoleDtoOut> update(RoleDtoIn dto, Long id) {
        Role role =  mapper.toDomain(dto);
        return new ResponseEntity<>(mapper.toDtoOut(roleUseCase.update(role, id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RoleDtoOut> getById(Long id) {
        return new ResponseEntity<>(mapper.toDtoOut(roleUseCase.getById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        roleUseCase.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<RoleDtoOut>> findAll(Integer page, Integer size, SortEnumDTO sortDirection) {
        return new ResponseEntity<>(mapper.toDtoOutList(roleUseCase.findAll(page, size, sortDirection.getValue())), HttpStatus.OK);
    }
}
