package com.fiverr.app.mic.userservices.infrastructure.db.postgres.repository.impl;

import com.fiverr.app.mic.userservices.domain.User;
import com.fiverr.app.mic.userservices.domain.exception.EntityNotFoundException;
import com.fiverr.app.mic.userservices.domain.repository.UserRepository;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.entity.UserEntity;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.mapper.UserEntityMapper;
import com.fiverr.app.mic.userservices.infrastructure.db.postgres.repository.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.fiverr.app.mic.userservices.domain.error.Errors.NOT_FOUND_RECORD;

@Repository
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserEntityMapper mapper;
    private final UserJpaRepository repository;

    @Override
    public User create(User userModel) {
        UserEntity userEntity = mapper.toEntity(userModel);
        return mapper.toModel(repository.save(userEntity));
    }

    @Override
    public User getById(Long id) {
        UserEntity userEntity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(NOT_FOUND_RECORD.getCode(),
                        String.format(NOT_FOUND_RECORD.getMessage(), id)));
        return mapper.toModel(userEntity);
    }

    @Override
    public User update(User userModel) {
        return this.create(userModel);
    }

    @Override
    public List<User> findAll() {
        return mapper.toModelList(repository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
