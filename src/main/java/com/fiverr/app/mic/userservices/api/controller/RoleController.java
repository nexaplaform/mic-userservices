package com.fiverr.app.mic.userservices.api.controller;

import com.fiverr.app.mic.userservices.api.service.RoleApi;
import com.fiverr.app.mic.userservices.api.service.dto.in.RoleDtoIn;
import com.fiverr.app.mic.userservices.api.service.dto.in.SortEnumDTO;
import com.fiverr.app.mic.userservices.api.service.dto.out.RoleDtoOut;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/roles")
@Tag(name = "Roles Operations.", description = "Operations related to user roles.")
public class RoleController implements RoleApi {

    @Override
    public ResponseEntity<RoleDtoOut> create(RoleDtoIn dto) {
        return RoleApi.super.create(dto);
    }

    @Override
    public ResponseEntity<RoleDtoOut> create(RoleDtoIn dto, Long id) {
        return RoleApi.super.create(dto, id);
    }

    @Override
    public ResponseEntity<RoleDtoOut> getById(Long id) {
        return RoleApi.super.getById(id);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return RoleApi.super.delete(id);
    }

    @Override
    public ResponseEntity<List<RoleDtoOut>> findAll(Integer page, Integer size, String sort, SortEnumDTO sortDirection) {
        return RoleApi.super.findAll(page, size, sort, sortDirection);
    }
}
