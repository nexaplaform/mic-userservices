package com.fiverr.app.mic.userservices.application.usecase.impl;

import com.fiverr.app.mic.userservices.application.usecase.RoleUseCase;
import com.fiverr.app.mic.userservices.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleUseCaseImpl implements RoleUseCase {

    @Override
    public Role create(Role model) {
        return RoleUseCase.super.create(model);
    }

    @Override
    public Role getById(Long id) {
        return RoleUseCase.super.getById(id);
    }

    @Override
    public Role update(Role model, Long id) {
        return RoleUseCase.super.update(model, id);
    }

    @Override
    public List<Role> findAll(Integer page, Integer size, String sort) {
        return RoleUseCase.super.findAll(page, size, sort);
    }

    @Override
    public void deleteById(Long id) {
        RoleUseCase.super.deleteById(id);
    }
}
