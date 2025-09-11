package com.fiverr.app.mic.userservices.application.usecase.impl;

import com.fiverr.app.mic.userservices.application.usecase.UserUseCase;
import com.fiverr.app.mic.userservices.domain.Role;
import com.fiverr.app.mic.userservices.domain.User;
import com.fiverr.app.mic.userservices.domain.repository.RoleRepository;
import com.fiverr.app.mic.userservices.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserUseCaseImpl implements UserUseCase {

    private final UserRepository uRepository;
    private final RoleRepository rRepository;

    @Override
    public User create(User userModel) {

        List<Role> roles = new ArrayList<>();
        if (Objects.nonNull(userModel.getRoles()) && !userModel.getRoles().isEmpty()) {
            userModel.getRoles().forEach( r -> {
                Role role = rRepository.getById(r.getId());
                roles.add(role);
            });
        }

        userModel.setRoles(roles);
        return uRepository.create(userModel);
    }

    @Override
    public User getById(Long id) {
        return uRepository.getById(id);
    }

    @Override
    public User update(User userModel, Long id) {
        User user = this.uRepository.getById(id);
        BeanUtils.copyProperties(userModel, user);
        user.setId(id);
        return uRepository.update(user);
    }

    @Override
    public List<User> findAll() {
        return uRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.getById(id);
        uRepository.deleteById(id);
    }
}
