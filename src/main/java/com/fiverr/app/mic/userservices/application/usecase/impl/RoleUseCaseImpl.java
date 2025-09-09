package com.fiverr.app.mic.userservices.application.usecase.impl;

import com.fiverr.app.mic.userservices.application.usecase.RoleUseCase;
import com.fiverr.app.mic.userservices.domain.Role;
import com.fiverr.app.mic.userservices.domain.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleUseCaseImpl implements RoleUseCase {

    private final RoleRepository repository;

    @Override
    public Role create(Role model) {
        return repository.create(model);
    }

    @Override
    public Role getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Role update(Role model, Long id) {
        Role role = this.getById(id);
        BeanUtils.copyProperties(model, role);
        role.setId(id);
        return repository.update(role);
    }

    @Override
    public List<Role> findAll(Integer page, Integer size, String sort) {
        return repository.findAll(page, size, sort);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
