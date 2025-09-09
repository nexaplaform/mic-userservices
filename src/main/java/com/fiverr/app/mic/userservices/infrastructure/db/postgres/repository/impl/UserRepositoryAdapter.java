package com.fiverr.app.mic.userservices.infrastructure.db.postgres.repository.impl;

import com.fiverr.app.mic.userservices.domain.User;
import com.fiverr.app.mic.userservices.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    @Override
    public User create(User model) {
        return UserRepository.super.create(model);
    }

    @Override
    public User getById(Long id) {
        return UserRepository.super.getById(id);
    }

    @Override
    public User update(User model, Long id) {
        return UserRepository.super.update(model, id);
    }

    @Override
    public List<User> findAll(Integer page, Integer size, String sort) {
        return UserRepository.super.findAll(page, size, sort);
    }

    @Override
    public void deleteById(Long id) {
        UserRepository.super.deleteById(id);
    }
}
