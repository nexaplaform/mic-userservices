package com.fiverr.app.mic.userservices.api.controller;

import com.fiverr.app.mic.userservices.api.service.UserApi;
import com.fiverr.app.mic.userservices.api.service.dto.in.SortEnumDTO;
import com.fiverr.app.mic.userservices.api.service.dto.in.UserDtoIn;
import com.fiverr.app.mic.userservices.api.service.dto.out.UserDtoOut;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
@Tag(name = "User Operations.", description = "Operations related to user administration.")
public class UserController implements UserApi {


    @Override
    public ResponseEntity<UserDtoOut> create(UserDtoIn dto) {
        return UserApi.super.create(dto);
    }

    @Override
    public ResponseEntity<UserDtoOut> update(UserDtoIn dto, Long id) {
        return UserApi.super.update(dto, id);
    }

    @Override
    public ResponseEntity<UserDtoOut> getById(Long id) {
        return UserApi.super.getById(id);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return UserApi.super.delete(id);
    }

    @Override
    public ResponseEntity<List<UserDtoOut>> findAll(Integer page, Integer size, SortEnumDTO sortDirection) {
        return UserApi.super.findAll(page, size, sortDirection);
    }
}
