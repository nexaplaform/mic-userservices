package com.fiverr.app.mic.userservices.application.usecase.impl;

import com.fiverr.app.mic.userservices.application.usecase.UserUseCase;
import com.fiverr.app.mic.userservices.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUseCaseImpl implements UserUseCase {

    @Override
    public User create(User model) {
        return UserUseCase.super.create(model);
    }

    @Override
    public User getById(Long id) {
        return UserUseCase.super.getById(id);
    }

    @Override
    public User update(User model, Long id) {
        return UserUseCase.super.update(model, id);
    }

    @Override
    public List<User> findAll(Integer page, Integer size, String sort) {
        return UserUseCase.super.findAll(page, size, sort);
    }

    @Override
    public void deleteById(Long id) {
        UserUseCase.super.deleteById(id);
    }
}
