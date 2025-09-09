package com.fiverr.app.mic.userservices.infrastructure.db.postgres.repository;

import com.fiverr.app.mic.userservices.infrastructure.db.postgres.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
