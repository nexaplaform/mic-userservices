package com.fiverr.app.mic.userservices.infrastructure.db.postgres.repository.impl;

import com.fiverr.app.mic.userservices.domain.Role;
import com.fiverr.app.mic.userservices.domain.exception.EntityNotFoundException;
import com.fiverr.app.mic.userservices.domain.repository.RoleRepository;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.entity.RoleEntity;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.mapper.RoleEntityMapper;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.repository.RoleJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.fiverr.app.mic.userservices.domain.error.Errors.NOT_FOUND_RECORD;

@Repository
@AllArgsConstructor
public class RoleRepositoryAdapter implements RoleRepository {

    private final RoleJpaRepository repository;
    private final RoleEntityMapper mapper;

    @Override
    public Role create(Role roleModel) {
        RoleEntity roleEntity = repository.save(mapper.toEntity(roleModel));
        return mapper.toModel(roleEntity);
    }

    @Override
    public Role getById(Long id) {
        RoleEntity roleEntity  = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(NOT_FOUND_RECORD.getCode(),
                String.format(NOT_FOUND_RECORD.getMessage(), id)));
        return mapper.toModel(roleEntity);
    }

    @Override
    public Role update(Role roleModel) {
        return this.create(roleModel);
    }

    @Override
    public List<Role> findAll() {
        return mapper.toModelList(repository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        this.getById(id);
        repository.deleteById(id);
    }
}
