package com.fiverr.app.mic.userservices.api.controller;

import com.fiverr.app.mic.userservices.api.service.UserApi;
import com.fiverr.app.mic.userservices.api.service.dto.in.SortEnumDTO;
import com.fiverr.app.mic.userservices.api.service.dto.in.UserDtoIn;
import com.fiverr.app.mic.userservices.api.service.dto.out.UserDtoOut;
import com.fiverr.app.mic.userservices.api.service.mapper.UserDtoMapper;
import com.fiverr.app.mic.userservices.application.usecase.UserUseCase;
import com.fiverr.app.mic.userservices.domain.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
@Tag(name = "User Operations.", description = "Operations related to user administration.")
public class UserController implements UserApi {

    private final UserUseCase useCase;
    private final UserDtoMapper mapper;

    @Override
    public ResponseEntity<UserDtoOut> create(UserDtoIn dto) {
        User user = mapper.toDomain(dto);
        return new ResponseEntity<>(mapper.toDto(useCase.create(user)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDtoOut> update(UserDtoIn dto, Long id) {
        User user = mapper.toDomain(dto);
        return new ResponseEntity<>(mapper.toDto(useCase.update(user, id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDtoOut> getById(Long id) {
        return new ResponseEntity<>(mapper.toDto(useCase.getById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        useCase.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<UserDtoOut>> findAll(Integer page, Integer size, SortEnumDTO sortDirection) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findAll(page, size, sortDirection.getValue())), HttpStatus.OK);
    }
}
